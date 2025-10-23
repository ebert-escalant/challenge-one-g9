# 🚀 Oracle Next Education (ONE) - Challenges Collection

<p>
    <a href="https://www.oracle.com/pe/education/oracle-next-education/">
        <img src="https://cdn2.gnarususercontent.com.br/1/1221562/b6256fa6-5fde-4cdd-a4a3-d33ebc90bb6c.png" target="_blank" alt="Oracle" height="60"/>
    </a>
    &nbsp;&nbsp;
    <a href="https://www.aluracursos.com/">
        <img src="https://app.aluracursos.com/assets/images/logos/logo-aluraespanhol.svg" target="_blank" alt="Alura Latam" height="60"/>
    </a>
</p>

## 📋 Descripción

Esta es mi colección de challenges completados durante el programa **Oracle Next Education (ONE) - Generación 9**. Cada challenge representa un proyecto práctico diseñado para aplicar y demostrar conocimientos específicos en desarrollo web y programación.

## 📚 Challenges Completados

### 🎁 Challenge 01 - Amigo Secreto
**Tecnologías**: Vite, JavaScript ES6+, HTML5, CSS3, Canvas Confetti

Aplicación web interactiva para organizar sorteos de amigo secreto. Permite agregar participantes, realizar sorteos aleatorios y mostrar resultados con efectos visuales.

**Características**:
- ➕ Gestión de participantes (agregar/eliminar)
- 🎲 Sorteo aleatorio
- 🎉 Efectos de confeti
- ✅ Validaciones de entrada
- 🔄 Reinicio de juego

[📂 Ver Challenge 01](./challenge-01/)

---

### � Challenge 02 - Conversor de Divisas
**Tecnologías**: Java 25, Maven, Swing, Gson, HttpClient

Conversor de divisas en tiempo real que permite realizar conversiones entre diferentes monedas latinoamericanas. Incluye dos modos de operación: interfaz gráfica con Swing y modo terminal interactivo.

**Características**:
- 🔄 Conversión en tiempo real usando API externa
- 🖥️ Interfaz gráfica amigable (GUI)
- ⌨️ Modo terminal interactivo
- 🌐 Integración con API de tasas de cambio
- 💰 Soporte para USD, PEN, ARS, BRL

[📂 Ver Challenge 02](./challenge-02/)

## 📁 Estructura del Repositorio

```
challenge/
├── README.md                   # Este archivo
├── challenge-01/               # Amigo Secreto
│   ├── src/
│   ├── public/
│   ├── index.html
│   ├── package.json
│   └── README.md
├── challenge-02/               # Conversor de Divisas
│   ├── src/
│   ├── pom.xml
│   └── README.md
└── challenge-03/               # Próximo challenge
    └── ...
```

## 🚀 Instrucciones Generales

### Prerrequisitos
- Node.js (versión 16 o superior) - Para Challenge 01
- Java JDK 25+ y Maven - Para Challenge 02
- Git
- Editor de código (recomendado: VS Code o IntelliJ IDEA)

### Clonar el Repositorio
```bash
git clone https://github.com/ebert-escalant/challenge-one-g9.git
cd challenge
```

### Ejecutar Challenge 01 (JavaScript)
```bash
cd challenge-01
npm install
npm run dev
```

### Ejecutar Challenge 02 (Java)
```bash
cd challenge-02
mvn clean compile
mvn exec:java -Dexec.mainClass="com.currencyconverter.main.Main"
```

## 📈 Progreso del Programa

- [x] **Challenge 01**: Amigo Secreto ✅ Completado
- [x] **Challenge 02**: Conversor de Divisas ✅ Completado
- [ ] **Challenge 03**: Próximamente ⏳

## 🎓 Competencias Desarrolladas

### Técnicas
- [x] Manipulación del DOM
- [x] Programación orientada a objetos (JavaScript & Java)
- [x] Manejo de eventos
- [x] Validación de datos
- [x] Modularización de código
- [x] Control de versiones con Git
- [x] APIs REST (consumo de APIs externas)
- [x] Desarrollo de interfaces gráficas (Swing)
- [x] Gestión de dependencias (Maven)
- [x] HttpClient y peticiones HTTP
- [ ] Testing
- [ ] Deployment

### Blandas
- [x] Resolución de problemas
- [x] Pensamiento lógico
- [x] Autodidacta
- [x] Organización de código
- [x] Documentación técnica

---

**🚀 Desarrollado durante el programa Oracle Next Education (ONE) G9**
