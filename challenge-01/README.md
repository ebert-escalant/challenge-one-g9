# 🎁 Amigo Secreto Challenge

[![Vite](https://img.shields.io/badge/Vite-646CFF?style=for-the-badge&logo=vite&logoColor=white)](https://vitejs.dev/)
[![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)](https://developer.mozilla.org/en-US/docs/Web/JavaScript)
[![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)](https://developer.mozilla.org/en-US/docs/Web/HTML)
[![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)](https://developer.mozilla.org/en-US/docs/Web/CSS)

## 📋 Descripción

**Amigo Secreto** es una aplicación web interactiva que permite organizar sorteos de amigo secreto de manera fácil y divertida. Los usuarios pueden agregar nombres de participantes y realizar un sorteo aleatorio para determinar quién será el "amigo secreto".

Este proyecto forma parte de los challenges de **ONE G9** (Oracle Next Education).

## ✨ Características

- 🎯 **Interfaz intuitiva**: Diseño limpio y fácil de usar
- ➕ **Agregar participantes**: Añade nombres de amigos para el sorteo
- 🗑️ **Eliminar participantes**: Remueve nombres antes del sorteo
- 🎲 **Sorteo aleatorio**: Selección aleatoria del ganador
- 🎉 **Animaciones**: Efectos de confeti al anunciar el ganador
- ✅ **Validaciones**: Previene nombres duplicados y vacíos
- 🔄 **Reiniciar juego**: Limpia la lista para comenzar de nuevo

## 🚀 Demo [ver](https://challenge-001-one-g9.vercel.app)

![Amigo Secreto Demo](public/amigo-secreto.png)

## 🛠️ Tecnologías Utilizadas

- **Vite**: Build tool y servidor de desarrollo
- **JavaScript ES6+**: Programación orientada a objetos y módulos
- **HTML5**: Estructura semántica
- **CSS3**: Estilos y diseño responsivo
- **Canvas Confetti**: Efectos de confeti
- **Google Fonts**: Tipografías personalizadas

## 📦 Instalación

### Prerrequisitos

- Node.js (versión 16 o superior)
- npm o bun

### Pasos

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/ebert-escalant/challenge-one-g9.git
   cd challenge-01
   ```

2. **Instalar dependencias**
   ```bash
   npm install
   # o
   bun install
   ```

3. **Ejecutar en modo desarrollo**
   ```bash
   npm run dev
   # o
   bun run dev
   ```

4. **Abrir en el navegador**
   ```
   http://localhost:5173
   ```

## 🎮 Cómo Usar

1. **Agregar participantes**: Escribe el nombre de un amigo en el campo de texto y haz clic en "Agregar" o presiona Enter
2. **Gestionar lista**: Puedes eliminar participantes haciendo clic en el ícono de eliminar (🗑️)
3. **Realizar sorteo**: Cuando tengas al menos 2 participantes, haz clic en "Sorteo amigo" para seleccionar al ganador
4. **Ver resultado**: Se mostrará el ganador con efectos de confeti
5. **Reiniciar**: Usa el botón "Limpiar lista" para comenzar un nuevo sorteo

## 📁 Estructura del Proyecto

```
challenge-01/
├── public/
│   └── amigo-secreto.png    # Imagen principal
├── src/
│   ├── game.js              # Lógica principal del juego
│   ├── item.js              # Clase para los participantes
│   ├── main.js              # Punto de entrada y manejo de eventos
│   ├── selector.js          # Utilidades para seleccionar elementos DOM
│   └── style.css            # Estilos de la aplicación
├── index.html               # Archivo HTML principal
├── package.json             # Configuración del proyecto
└── README.md               # Este archivo
```

## 🏗️ Construcción para Producción

```bash
npm run build
# o
bun run build
```

Los archivos optimizados se generarán en la carpeta `dist/`.

## 🔍 Vista Previa de Producción

```bash
npm run preview
# o
bun run preview
```

## 📝 Características Técnicas

- **Arquitectura**: Programación orientada a objetos con clases ES6
- **Modularidad**: Código organizado en módulos separados
- **Validaciones**: Prevención de nombres duplicados y entradas vacías
- **Accesibilidad**: Diseño pensado para la usabilidad
- **Responsive**: Adaptable a diferentes tamaños de pantalla

## 🎯 Objetivos del Challenge

Este proyecto demuestra competencias en:
- Manipulación del DOM
- Programación orientada a objetos en JavaScript
- Manejo de eventos
- Validación de datos
- Diseño de interfaces de usuario
- Organización de código modular
