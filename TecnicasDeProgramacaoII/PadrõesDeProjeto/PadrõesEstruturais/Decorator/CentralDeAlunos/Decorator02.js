//Interface Componente
class Curso{
    constructor(){
        this.descricao = 'Curso';
    }

    getDescricao(){
        return this.descricao;
    }

    custo(){
        return 0;
    }
}

//Implementação concreta da interface Componente para serviços personalizados
class CursoPersonalizado extends Curso{
    constructor(tipocurso, periodo){
        super();
        this.descricao = `Curso ${tipocurso} no periodo da ${periodo}`;
        this.tipocurso = tipocurso;
        this.periodo = periodo;
    }

    custo(){
        let precoBase = 0;
        return precoBase.toFixed(2);
    }

}

//Decorator Abstrato:
class Decorator extends Curso{
    constructor(curso){
        super();
        this.curso = curso;
    }

    getDescrição(){
        return this.curso.getDescricao();
    }

    custo(){
        return this.curso.custo();
    }
}

//Decorador Concreto para adicionar serviços extras:
//Internet
class Internet2Gb extends Decorator{
    constructor(curso){
        super(curso);
    }

    getDescricao(){
        return `${this.curso.getDescricao()}, Internet2Gb`;
    }

    custo(){
        return(parseFloat(this.curso.custo()) + 9.90).toFixed(2)
    }

}

class Internet5Gb extends Decorator{
    constructor(curso){
        super(curso);
    }

    getDescricao(){
        return `${this.curso.getDescricao()}, Internet5Gb`;
    }

    custo(){
        return(parseFloat(this.curso.custo()) + 19.90).toFixed(2)
    }

}

class Internet10Gb extends Decorator{
    constructor(curso){
        super(curso);
    }

    getDescricao(){
        return `${this.curso.getDescricao()}, Internet10Gb`;
    }

    custo(){
        return(parseFloat(this.curso.custo()) + 29.90).toFixed(2)
    }

}

//Estacionamento
class Bicicleta extends Decorator{
    constructor(curso){
        super(curso);
    }

    getDescricao(){
        return `${this.curso.getDescricao()}, Bicicleta`;
    }

    custo(){
        return(parseFloat(this.curso.custo()) + 30.00).toFixed(2)
    }

}

class Moto extends Decorator{
    constructor(curso){
        super(curso);
    }

    getDescricao(){
        return `${this.curso.getDescricao()}, Moto`;
    }

    custo(){
        return(parseFloat(this.curso.custo()) + 60.00).toFixed(2)
    }

}

class Carro extends Decorator{
    constructor(curso){
        super(curso);
    }

    getDescricao(){
        return `${this.curso.getDescricao()}, Carro`;
    }

    custo(){
        return(parseFloat(this.curso.custo()) + 120.00).toFixed(2)
    }

}

//Aluguel de Armario
class Litros10 extends Decorator{
    constructor(curso){
        super(curso);
    }

    getDescricao(){
        return `${this.curso.getDescricao()}, 10 Litros`;
    }

    custo(){
        return(parseFloat(this.curso.custo()) + 6.00).toFixed(2)
    }

}

class Litros20 extends Decorator{
    constructor(curso){
        super(curso);
    }

    getDescricao(){
        return `${this.curso.getDescricao()}, 20 Litros`;
    }

    custo(){
        return(parseFloat(this.curso.custo()) + 10.00).toFixed(2)
    }

}

class Litros40 extends Decorator{
    constructor(curso){
        super(curso);
    }

    getDescricao(){
        return `${this.curso.getDescricao()}, 40 Litros`;
    }

    custo(){
        return(parseFloat(this.curso.custo()) + 15.00).toFixed(2)
    }

}

//Cursos Extras

class Cursos5 extends Decorator{
    constructor(curso){
        super(curso);
    }

    getDescricao(){
        return `${this.curso.getDescricao()}, 5 Cursos`;
    }

    custo(){
        return(parseFloat(this.curso.custo()) + 9.90).toFixed(2)
    }

}

class Cursos15 extends Decorator{
    constructor(curso){
        super(curso);
    }

    getDescricao(){
        return `${this.curso.getDescricao()}, 15 Cursos`;
    }

    custo(){
        return(parseFloat(this.curso.custo()) + 19.99).toFixed(2)
    }

}

class CursosIlimitados extends Decorator{
    constructor(curso){
        super(curso);
    }

    getDescricao(){
        return `${this.curso.getDescricao()}, Cursos Ilimitados`;
    }

    custo(){
        return(parseFloat(this.curso.custo()) + 24.90).toFixed(2)
    }

}

//Exemplo de Uso
// Simulação no Index


function montarCurso(){
    // Obtendo Curso Selecionado:
    let cursoSelecionado = document.querySelector('input[name="tipocurso"]:checked');
    let tipocurso = cursoSelecionado ? cursoSelecionado.value: '';

    
    // Obtendo Periodo Selecionado:
    let periodoSelecionado = document.querySelector('input[name="periodo"]:checked');
    let periodo = periodoSelecionado ? periodoSelecionado.value: '';

    // Criando Objeto CursoPersonalizada com base nas seleções do usuarios:
    let cursoPersonalizado = new CursoPersonalizado(tipocurso, periodo);

// Aplicar decoradores para serviços extras, se selecionados

//Internet

    let internet2GbCheckbox = document.querySelector('input[name="internet2Gb"]:checked');
    if (internet2GbCheckbox) {
        cursoPersonalizado = new Internet2Gb(cursoPersonalizado);
    }

    let internet5GbCheckbox = document.querySelector('input[name="internet5Gb"]:checked');
    if (internet5GbCheckbox) {
        cursoPersonalizado = new Internet5Gb(cursoPersonalizado);
    }

    let internet10GbCheckbox = document.querySelector('input[name="internet10Gb"]:checked');
    if (internet10GbCheckbox) {
        cursoPersonalizado = new Internet10Gb(cursoPersonalizado);
    }

    //Estacionamento
    let bicicletaCheckbox = document.querySelector('input[name="bicicleta"]:checked');
    if (bicicletaCheckbox) {
        cursoPersonalizado = new Bicicleta(cursoPersonalizado);
    }

    let motoCheckbox = document.querySelector('input[name="moto"]:checked');
    if (motoCheckbox) {
        cursoPersonalizado = new Moto(cursoPersonalizado);
    }

    let carroCheckbox = document.querySelector('input[name="carro"]:checked');
    if (carroCheckbox) {
        cursoPersonalizado = new Carro(cursoPersonalizado);
    }

    //Aluguel Armario
    let litros10Checkbox = document.querySelector('input[name="litros10"]:checked');
    if (litros10Checkbox) {
        cursoPersonalizado = new Litros10(cursoPersonalizado);
    }

    let litros20Checkbox = document.querySelector('input[name="litros20"]:checked');
    if (litros20Checkbox) {
        cursoPersonalizado = new Litros20(cursoPersonalizado);
    }

    let litros40Checkbox = document.querySelector('input[name="litros40"]:checked');
    if (litros40Checkbox) {
        cursoPersonalizado = new Litros40(cursoPersonalizado);
    }

    //CursosExtras
    let cursos5Checkbox = document.querySelector('input[name="cursos5"]:checked');
    if (cursos5Checkbox) {
        cursoPersonalizado = new Cursos5(cursoPersonalizado);
    }

    let cursos15Checkbox = document.querySelector('input[name="cursos15"]:checked');
    if (cursos15Checkbox) {
        cursoPersonalizado = new Cursos15(cursoPersonalizado);
    }

    let cursosIlimitadosCheckbox = document.querySelector('input[name="cursosIlimitados"]:checked');
    if (cursosIlimitadosCheckbox) {
        cursoPersonalizado = new CursosIlimitados(cursoPersonalizado);
    }

    // Obter o custo total do serviço  personalizado
    let custoTotal = parseFloat(cursoPersonalizado.custo());

    // Exibir o custo total do pedido
    let totalPedidoElement = document.getElementById("total-pedido");
    totalPedidoElement.textContent = "R$ " + custoTotal.toFixed(2);

}









