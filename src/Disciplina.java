import java.util.ArrayList;


public class Disciplina {


    private int codigo;

    ArrayList<Estudante> lista_alunos = new ArrayList();

    public Disciplina(int cod){
        codigo = cod;
    }

    public void setNovoAluno(int nusp, double p1, double p2, double p3){

        lista_alunos.add(new Estudante(nusp,p1,p2,p3));

    }

    public int getNumeroAlunosMatriculados(){

        return lista_alunos.size();

    }

    public int getQntAlunosAprovados(){
        int qnt_aprovados = 0;

        for(int i=0; i<lista_alunos.size(); i++){
            if (lista_alunos.get(i).getAprovacao()){
                qnt_aprovados ++;
            }
        }

        return qnt_aprovados;

    }

    public int getQntReprovados(){
        int qnt_reprovados = 0;
        int qnt_aprovados;

        qnt_aprovados= this.getQntAlunosAprovados();
        qnt_reprovados = lista_alunos.size() - qnt_aprovados;

        return qnt_reprovados;
    }


    public int AlunoExiste(int nusp){

        for(int i=0; i<lista_alunos.size(); i++){
            if (lista_alunos.get(i).getNUSP() == nusp){
                return 1;
            }
        }

        return 0;

    }

    public int getCod(){
        return this.codigo;
    }




    /*


    public int getNotaAlunoP1(int nusp){

        for(int i=0; i<lista_alunos.size(); i++){
            if (lista_alunos.get(i).getNUSP() == nusp){
                return lista_alunos.get(i).getP1();
            }
        }

        return 11;

    }

    public int getNotaAlunoP2(int nusp){

        for(int i=0; i<lista_alunos.size(); i++){
            if (lista_alunos.get(i).getNUSP() == nusp){
                return lista_alunos.get(i).getP2();
            }
        }

        return 11;

    }

    public int getNotaAlunoP3(int nusp){

        for(int i=0; i<lista_alunos.size(); i++){
            if (lista_alunos.get(i).getNUSP() == nusp){
                return lista_alunos.get(i).getP3();
            }
        }

        return 11;

    }


    public double getMediaAluno(int nusp){

        for (Estudante lista_aluno : lista_alunos) {
            if (lista_aluno.getNUSP() == nusp) {
                return lista_aluno.getMediaFinal();
            }
        }

        return 11;

    }

    public int ImprimirAlunosAprovados(){

        System.out.println("Lista de Alunos Aprovados:");
        for(int i=0; i<lista_alunos.size(); i++){
            if (lista_alunos.get(i).getAprovacao()){
                System.out.printf("%d\n", lista_alunos.get(i).getNUSP());
            }
        }

        return 0;

    }

    public int ImprimirAlunosReprovados(){

        System.out.println("Lista de Alunos Reprovados:");
        for(int i=0; i<lista_alunos.size(); i++){

            if (!lista_alunos.get(i).getAprovacao()){
                System.out.printf("%d\n", lista_alunos.get(i).getNUSP());
            }
        }

        return 0;

    }

     */


}
