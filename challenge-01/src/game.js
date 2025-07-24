import { Item } from "./item";

export class Game {
  constructor() {
    this.items = [];
  }

  addItem(name) {
    this.items.push(new Item(name));
  }

  removeItem(itemName) {
    this.items = this.items.filter(item => item.name !== itemName);
  }

  getItems() {
    return this.items;
  }

  clearItems() {
    this.items = [];
  }
}