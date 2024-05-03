// Flyweight Factory:
class FabricaFlyweight{
    constructor(){
        this.flyweights = {};
    }

    getFlyweight(codigo){
        if(!this.flyweights[codigo]){
            this.flyweights[codigo]=new ProdutoFlyweight(codigo);
        }
        return this.flyweights[codigo];
    }
}

// Flyweight
class ProdutoFlyweight{
    constructor(codigo){
        this.codigo = codigo;
    }

    exibirDetalhes(nome, preco){
        console.log(`| COD:${this.codigo} | R$:${preco.toFixed(2)} | Produto:${nome}`);
    }
}

// Cliente
class Cliente{
    constructor(){
        this.fabricaFlyweight = new FabricaFlyweight();
        this.pedido = [];
    }

    addProduto(codigo, nome, preco){
        const flyweight = this.fabricaFlyweight.getFlyweight(codigo);
        this.pedido.push({flyweight, nome, preco});
    }

    exibirPedido(){
        console.log("Pedidos:");
        this.pedido.forEach(item => {
            item.flyweight.exibirDetalhes(item.nome, item.preco);
        })
    }
}

// USO DO PROJETO:
const cliente = new Cliente();
cliente.addProduto('001', 'Camiseta', 39.90);
cliente.addProduto('002', 'Calça Jeans', 89.90);
cliente.addProduto('001', 'Bone', 39.90);
cliente.exibirPedido();



