// Componente:
class ComponenteAluno{

    obterNome(){};

    obterNotas(){};

    obterFaltas(){};
};

// Folha:
class Aluno extends ComponenteAluno{
    constructor(nome, notas, faltas){
        super();
        this.nome = nome;
        this.notas = notas;
        this.faltas = faltas;
    };

    obterNome(){
        return this.nome;
    };

    obterNotas(){
        return this.notas;
    };

    obterFaltas(){
        return this.faltas;
    };
};

// Composto:
class Turma extends ComponenteAluno{
    constructor(nome){
        super();
        this.nome = nome;
        this.listaAluno = [];
    };

    obterNome(){
        return this.nome;
    };

    obterNotas(){
        let listaNota = [];
        for (let aluno of this.listaAluno){
            listaNota = listaNota.concat(aluno.obterNotas());
        };
        return listaNota;
    };

    obterFaltas(){
        let listaFalta = [];
        for (let aluno of this.listaAluno){
            listaFalta = listaFalta.concat(aluno.obterFaltas());
        };
        return listaFalta;
    };

    obterRelacaoAlunos(){
        return this.listaAluno.map(aluno => {
            return{
                nome:   aluno.obterNome(),
                notas:  aluno.obterNotas(),
                faltas: aluno.obterFaltas()
            };
        });
    };

    adicionarAluno(aluno){
        this.listaAluno.push(aluno);
    };

    removerAluno(aluno){
        const index = this.listaAluno.indexOf(aluno);
        if(index !== -1){
            this.obterRelacaoAlunos.splice(index, 1);
        };
    };
};

// Interface de utilização do Padrão: ##########################################################
// Criando Alunos:
const aluno1 = new Aluno("João da Silva", [8.2, 7.5, "MED", "P3", "MF"], [4, 0, 0, 0, 2]);
const aluno2 = new Aluno("Aline da Silva", [0.2, 6.5, "MED", "P3", "MF"], [0, 3, 0, 0, 2]);
const aluno3 = new Aluno("Paulo da Silva", [4.8, 5.5, "MED", "P3", "MF"], [4, 0, 0, 0, 2]);
const aluno4 = new Aluno("Bruno da Silva", [1.2, 2.5, "MED", "P3", "MF"], [0, 3, 0, 2, 2]);

// Criando Turma:
const turma1 = new Turma("FATEC-DSM-3SEM");
turma1.adicionarAluno(aluno1);
turma1.adicionarAluno(aluno2);
turma1.adicionarAluno(aluno3);
turma1.adicionarAluno(aluno4);

/*/ Exibindo notas e faltas da turma:
console.log("--------------------------------------------")
console.log("Notas da", turma1.obterNome() + ":", turma1.obterNotas());
console.log("--------------------------------------------")
console.log("Falta da", turma1.obterNome() + ":", turma1.obterFaltas());
console.log("--------------------------------------------")*/

// Exibindo relação de alunos:
console.log("-------------------------------------------------------------------------------------------");
console.log("TURMA: ", turma1.obterNome());
console.log("-------------------------------------------------------------------------------------------");
console.log(" NOME DO ALUNO         |   P1   P2    MED   P3    MF           |   1  2  3  4  5   |");
console.log("-------------------------------------------------------------------------------------------");
turma1.obterRelacaoAlunos().forEach(aluno => {
    console.log("Nome:", aluno.nome, "\t", aluno.notas, "\t", aluno.faltas);
})
console.log("-------------------------------------------------------------------------------------------");