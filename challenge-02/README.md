# Challenge 02 - Conversor de Divisas 💱

## 📋 Descripción

Conversor de divisas desarrollado en Java que permite realizar conversiones entre diferentes monedas utilizando tasas de cambio en tiempo real obtenidas a través de una API externa. El proyecto cuenta con dos modos de ejecución: interfaz gráfica (GUI) y modo terminal.

## ✨ Características

- 🔄 Conversión en tiempo real entre múltiples divisas
- 🖥️ Interfaz gráfica amigable con Swing
- ⌨️ Modo terminal interactivo
- 🌐 Integración con API de tasas de cambio (fxratesapi.com)
- 💰 Soporte para múltiples monedas latinoamericanas

## 🪙 Monedas Soportadas

- **USD** - Dólar estadounidense
- **PEN** - Sol peruano
- **ARS** - Peso argentino
- **BRL** - Real brasileño

## 🛠️ Tecnologías

- **Java 25**
- **Maven** - Gestión de dependencias
- **Gson** - Procesamiento de JSON
- **Java Swing** - Interfaz gráfica
- **HttpClient** - Consumo de API REST

## 📦 Dependencias

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.13.2</version>
</dependency>
```

## 📁 Estructura del Proyecto

```
challenge-02/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── currencyconverter/
                    ├── contants/
                    │   └── Currency.java          # Enumeración de monedas
                    ├── helper/
                    │   └── HttpService.java       # Servicio HTTP
                    ├── main/
                    │   ├── CurrencyConverter.java # Lógica de conversión
                    │   ├── Main.java              # Modo GUI
                    │   └── TerminalMode.java      # Modo terminal
                    └── models/
                        └── ConvertOption.java     # Modelo de opciones
```

## 🚀 Instalación

### Prerrequisitos

- Java JDK 25 o superior
- Maven 3.6+

### Pasos de instalación

1. **Clonar el repositorio**
```bash
git clone https://github.com/ebert-escalant/challenge-one-g9.git
cd challenge-02
```

2. **Compilar el proyecto**
```bash
mvn clean compile
```

3. **Empaquetar (opcional)**
```bash
mvn package
```

## 💻 Uso

### Modo Interfaz Gráfica (GUI)

Ejecutar la clase `Main`:

```bash
mvn exec:java -Dexec.mainClass="com.currencyconverter.main.Main"
```

**Características de la GUI:**
- Selección de moneda de origen y destino mediante ComboBox
- Campo de entrada para el monto a convertir
- Botón de conversión
- Panel de resultados que muestra el valor convertido

### Modo Terminal

Ejecutar la clase `TerminalMode`:

```bash
mvn exec:java -Dexec.mainClass="com.currencyconverter.main.TerminalMode"
```

**Flujo de trabajo:**
1. Se muestra un menú con las opciones de conversión disponibles
2. Seleccionar una opción ingresando el número correspondiente
3. Ingresar el valor a convertir
4. Ver el resultado de la conversión
5. Elegir "otro" para salir

## 🔧 Funcionamiento Técnico

### Conversión de Divisas

El algoritmo de conversión implementado en `CurrencyConverter` funciona de la siguiente manera:

1. **Mismo tipo de moneda**: Retorna el mismo valor
2. **Desde moneda base (USD)**: Multiplica por la tasa de cambio
3. **Hacia moneda base (USD)**: Divide por la tasa de cambio
4. **Entre monedas no base**: Convierte primero a USD y luego a la moneda destino

```java
// Ejemplo de conversión
double valueInBase = value / rates.get(from);
return valueInBase * rates.get(to);
```

### Obtención de Tasas

Las tasas de cambio se obtienen de la API externa al iniciar la aplicación:

```java
CurrencyConverter.loadRates();
```

La API utilizada: `https://api.fxratesapi.com/latest`

## 📊 Ejemplos de Uso

### Ejemplo 1: USD a PEN
- **Entrada**: 100 USD
- **Salida**: ~370 PEN (dependiendo de la tasa actual)

### Ejemplo 2: BRL a ARS
- **Entrada**: 50 BRL
- **Proceso**: 50 BRL → USD → ARS
- **Salida**: Valor convertido en ARS

## 🎨 Capturas de Pantalla

### Interfaz Gráfica
La interfaz incluye:
- Panel de conversión con selectores de moneda
- Campo de entrada numérico
- Botón de conversión
- Panel de resultados

### Modo Terminal
```
[0]: Dólar estadounidense => Sol peruano
[1]: Sol peruano => Dólar estadounidense
[2]: Dólar estadounidense => Peso argentino
[3]: Peso argentino => Dólar estadounidense
...
[otro]: Salir
```

## ⚠️ Manejo de Errores

El sistema incluye validaciones para:
- Valores vacíos o inválidos
- Monedas no soportadas
- Errores de conexión con la API
- Tasas no cargadas

Los errores se muestran mediante:
- **GUI**: Diálogos de `JOptionPane`
- **Terminal**: Mensajes en consola

## 👨‍💻 Autor

Desarrollado como parte del programa ONE - Oracle Next Education

## 📄 Licencia

Este proyecto es de código abierto y está disponible para fines educativos.

---

⭐ **Nota**: Las tasas de cambio se actualizan en tiempo real al iniciar la aplicación y dependen de la disponibilidad de la API externa.
