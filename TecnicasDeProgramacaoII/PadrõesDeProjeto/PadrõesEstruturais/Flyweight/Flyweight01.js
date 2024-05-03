// Flyweight Factory
class FlyweightFactory{
    constructor(){
        this.flyweights = {};
    }

    getFlyweight(key){
        if(!this.flyweights[key]){
            this.flyweights[key] = new Flyweight(key);
        }
        return this.flyweights[key];
    }
}

// Flyweight:
class Flyweight{
    constructor(intrinsicState){
        this.intrinsicState = intrinsicState;
    }

    operation(extrinsicState){
        console.log(`Intrinsic State: ${this.intrinsicState}, Extrinsic State: ${extrinsicState}`);
    }
}

// Client:
class Client{
    constructor(){
        this.flyweightFactory = new FlyweightFactory();
    }

    run(){
        const flyweightA = this.flyweightFactory.getFlyweight('A');
        const flyweightB = this.flyweightFactory.getFlyweight('B');
        const flyweightC = this.flyweightFactory.getFlyweight('C');

        flyweightA.operation('State 1');
        flyweightB.operation('State 2');
        flyweightC.operation('State 3');
        flyweightA.operation('State 4');
    }
}

// Uso do Padrão (Usage):
const client = new Client();
client.run();