import confetti from "canvas-confetti";
import { Game } from "./game";
import { $ } from "./selector";

document.addEventListener("DOMContentLoaded", () => {

  let game = new Game();

  const addButton = $('#add-item-button');
  const startButton = $('#start-game-button');
  const resetButton = $('#reset-game-button');
  const inputField = $('#add-item-input');
  const itemList = $('#list');
  const acceptWinnerButton = $('#accept-winner-button');

  const handleAddItem = () => {
    const itemName = inputField.value;

    if (!itemName || itemName.trim() === '') {
      alert("Por favor, ingresa un nombre válido.");
      return;
    }

    const existingItems = game.getItems().map(item => item.name.toLowerCase());

    if (existingItems.includes(itemName.trim().toLowerCase())) {
      alert("Este nombre ya ha sido agregado.");
      return;
    }

    game.addItem(itemName.trim());
    inputField.value = ''; // Clear input after adding

    renderItems();
  };

  const handleDeleteItem = (event) => {
    const itemName = event.currentTarget.dataset.itemName;
    console.log(event.currentTarget);
    console.log(`Eliminando item: ${itemName}`);
    game.removeItem(itemName);

    renderItems();
  };

  const handleStartGame = () => {
    const items = game.getItems();
    
    if (items.length < 2) {
      alert("Necesitas al menos dos amigos para iniciar el juego.");
      return;
    }

    const shuffledItems = items.sort(() => Math.random() - 0.5);
    const winner = shuffledItems[0];

    const winnerDialog = $('#winner-dialog');
    winnerDialog.querySelector('p').textContent = `El ganador es: ${winner.name}  🎁🎉🎉`;
    winnerDialog.style.display = 'flex';

    confetti({
      particleCount: 100,
      spread: 70,
      origin: { y: 0.6 }
    });
  };

  const handleResetGame = () => {
    game.clearItems();
    inputField.value = '';
    renderItems();
  };

  const renderItems = () => {
    const template = document.getElementById('list-item-template');
    itemList.innerHTML = ''; // Clear existing items

    const items = game.getItems();

    items.forEach(item => {
      const clone = template.content.cloneNode(true);
      clone.querySelector('.name').textContent = item.name;
      clone.querySelector('.action').dataset.itemName = item.name;
      clone.querySelector('.action').addEventListener('click', handleDeleteItem);
      itemList.appendChild(clone);
    });

    // Enable or disable buttons based on the number of items
    if (items.length > 0) {
      startButton.removeAttribute('disabled');
      resetButton.removeAttribute('disabled');
    } else {
      startButton.setAttribute('disabled', 'true');
      resetButton.setAttribute('disabled', 'true');
    }
  };

  addButton?.addEventListener('click', handleAddItem);
  startButton?.addEventListener('click', handleStartGame);
  resetButton?.addEventListener('click', handleResetGame);
  inputField?.addEventListener('keypress', (event) => {
    if (event.key === 'Enter') {
      handleAddItem();
    }
  });
  acceptWinnerButton?.addEventListener('click', () => {
    const winnerDialog = $('#winner-dialog');
    winnerDialog.style.display = 'none';
    winnerDialog.querySelector('p').textContent = '';
  });

  startButton?.setAttribute('disabled', 'true');
  resetButton?.setAttribute('disabled', 'true');
});