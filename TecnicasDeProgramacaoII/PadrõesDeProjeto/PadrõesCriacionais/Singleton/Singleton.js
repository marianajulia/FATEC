const Singleton = (function() {
    let instance;

    function createInstance() {
        // Aqui você pode colocar o código para inicializar o objeto Singleton
        return {
            // Propriedades e métodos do Singleton
            exampleProperty: "Hello",
            exampleMethod: function() {
                console.log("Singleton method");
            }
        };
    }

    return {
        getInstance: function() {
            if (!instance) {
                instance = createInstance();
            }
            return instance;
        }
    };
})();

// Exemplo de uso
const singletonInstance1 = Singleton.getInstance();
const singletonInstance2 = Singleton.getInstance();

console.log(singletonInstance1 === singletonInstance2); // Saída: true, ambas as instâncias são iguais

singletonInstance1.exampleMethod(); // Saída: Singleton method

