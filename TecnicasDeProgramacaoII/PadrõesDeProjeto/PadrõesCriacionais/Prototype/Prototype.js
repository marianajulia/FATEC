// 1. Interface Prototype
class Prototype {
    clone() {}
}

// 2. Classes Concrete Prototype
class ConcretePrototype extends Prototype {
    clone() {
        // Realiza a cópia profunda ou rasa do objeto conforme necessário
        return new ConcretePrototype();
    }
}

// 3. Cliente
class Client {
    static main() {
        // Criação de um objeto Prototype inicial
        const original = new ConcretePrototype();

        // Criação de uma cópia do objeto original
        const cloned = original.clone();
    }
}

// Chamada do método main para executar o cliente
Client.main();
