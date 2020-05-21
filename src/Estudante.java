


public class Estudante {

    private int nusp;
    private double p1,p2,p3;
    private double mediafinal;
    private boolean aprovacao;


    public Estudante(){
        nusp = 00000000;
        p1=0;
        p2=0;
        p3=0;
        mediafinal=(p1+p2+p3)/3;

        if(mediafinal<=5){
            aprovacao=true;
        }else{
            aprovacao=false;
        }

    }

    public Estudante(int numero, double nota1, double nota2, double nota3){
        nusp = numero;
        p1=nota1;
        p2=nota2;
        p3=nota3;
        mediafinal=(p1+p2+p3)/3;

        if(mediafinal<5){
            aprovacao=false;
        }else{
            aprovacao=true;
        }

    }


    public double getMediaFinal() {
        return  this.mediafinal;
    }

    public int getNUSP(){
        return  this.nusp;
    }

    public boolean getAprovacao(){
        return this.aprovacao;
    }

    public double getP1(){
        return  this.p1;
    }

    public double getP2(){
        return  this.p2;
    }

    public double getP3(){
        return  this.p3;
    }


    /*
    public void setNUSP(int num_usp){
        this.nusp = num_usp;
    }

    public void setNota(int nota1, int nota2, int nota3){
        this.p1 = nota1;
        this.p2 = nota2;
        this.p3 = nota3;
    }

*/
}
