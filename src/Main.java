import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;




public class Main {

    public static void main(String[] args) throws InterruptedException {

        // CLI
        Scanner input = new Scanner(System.in);
        int controle_cli;

        ArrayList<Disciplina> disciplinas = new ArrayList();

        while(true) {
            for (int i = 0; i < 50; ++i) System.out.println(); // limpa a tela
            System.out.println("Bem-Vindo ao Software NotaFinal");
            System.out.println("Oque gostaria de fazer?");
            System.out.println("1 - Cadastrar Disciplina");
            System.out.println("2 - Cadastrar Aluno");
            System.out.println("3 - Consultas");
            System.out.print("Digite o numero correspondente: ");

            controle_cli = input.nextInt();
            int text_controle_cli;
            boolean controle_disciplina_existente;
            boolean controle_aluno_existente;
            String texto_converter;
            int numero_usp;
            int nota_p1;
            int nota_p2;
            int nota_p3;
            double mediafinal;
            int controle_cod_disciplina;
            int indice = 0;
            controle_aluno_existente = false;



            //TOMADA DE DECISÃO CLI
            if (controle_cli == 1) {
                controle_disciplina_existente = false;
                for (int i = 0; i < 50; ++i) System.out.println(); // limpa a tela

                System.out.println("Digite o codigo da disciplina:");
                System.out.print("SSC");
                controle_cli = input.nextInt();
                text_controle_cli = controle_cli;
                texto_converter = Integer.toString(text_controle_cli);

                if (texto_converter.length() != 4) {
                    System.out.println("Codigo Invalido");
                    Thread.sleep(2000);
                } else {
                    for (int i = 0; i < disciplinas.size(); i++) {
                        if (disciplinas.get(i).getCod() == controle_cli) {
                            controle_disciplina_existente = true;
                            System.out.println("Disciplina ja existente");
                            Thread.sleep(2000);
                        }
                    }
                    if (!controle_disciplina_existente) {
                        disciplinas.add(new Disciplina(controle_cli));
                        System.out.println("Disciplina Adicionada");
                        Thread.sleep(2000);

                    }


                }


                //cadastro de disciplina
            }

            if (controle_cli == 2) {
                for (int i = 0; i < 50; ++i) System.out.println(); // limpa a tela


                System.out.println("Digite o codigo da disciplina na qual o aluno sera cadastrado:");
                System.out.print("SSC");
                controle_cod_disciplina = input.nextInt();

                for (int i = 0; i < disciplinas.size(); i++) {
                    if (disciplinas.get(i).getCod() == controle_cod_disciplina) {
                        indice = 1;

                        System.out.println("Qual o numero usp do aluno:");
                        numero_usp = input.nextInt();
                        System.out.println("Qual a nota da P1:");
                        nota_p1 = input.nextInt();
                        System.out.println("Qual a nota da P2:");
                        nota_p2 = input.nextInt();
                        System.out.println("Qual a nota da P3:");
                        nota_p3 = input.nextInt();

                        text_controle_cli = numero_usp;
                        texto_converter = Integer.toString(text_controle_cli);

                        if (texto_converter.length() != 7) {
                            System.out.println("NumeroUsp Invalido");
                            Thread.sleep(2000);
                        } else {
                            if (disciplinas.get(i).lista_alunos.size() == 0) {
                                if (0 <= nota_p1 && nota_p1 <= 10 && 0 <= nota_p2 && nota_p2 <= 10 && 0 <= nota_p3 && nota_p3 <= 10) {
                                    disciplinas.get(i).setNovoAluno(numero_usp, nota_p1, nota_p2, nota_p3);
                                    System.out.println("Aluno Adicionado");
                                    Thread.sleep(2000);
                                } else {
                                    System.out.println("Nota Invalida");
                                    Thread.sleep(2000);
                                }

                            } else {

                                for (int j = 0; j < disciplinas.get(i).lista_alunos.size(); j++) {
                                    if (disciplinas.get(i).AlunoExiste(numero_usp) == 1) {
                                        controle_aluno_existente = true;
                                        System.out.println("Aluno ja existente");
                                        Thread.sleep(2000);
                                    } else {

                                        if (0 <= nota_p1 && nota_p1 <= 10 && 0 <= nota_p2 && nota_p2 <= 10 && 0 <= nota_p3 && nota_p3 <= 10) {
                                            disciplinas.get(i).setNovoAluno(numero_usp, nota_p1, nota_p2, nota_p3);
                                            System.out.println("Aluno Adicionado");
                                            j = disciplinas.get(i).lista_alunos.size();
                                            Thread.sleep(2000);
                                        } else {
                                            System.out.println("Nota Invalida");
                                            Thread.sleep(2000);
                                        }

                                    }

                                }

                            }


                        }


                    }

                }


                if (indice == 0) {
                    System.out.println("Disciplina nao cadastrada");
                    Thread.sleep(2000);
                }


                //cadastro aluno
            }

            if (controle_cli == 3) {
                for (int i = 0; i < 50; ++i) System.out.println(); // limpa a tela

                int controle_nusp;
                boolean ind;

                System.out.println("Qual consulta gostaria de ralizar?");
                System.out.println("1 - Qntd de alunos matriculados na disciplina");
                System.out.println("2 - Qntd de alunos aprovados na dsiciplina");
                System.out.println("3 - Qntd de alunos reprovados na disiciplina");
                System.out.println("4 - Notas de um aluno da disciplina");
                System.out.println("5 - Lista de alunos na disciplina ordenado pela media");
                System.out.println("6 - Lista de alunos na disciplina ordenado pelo nusp");
                System.out.println("7 - Lista de alunos aprovados na dsiciplina");
                System.out.println("8 - Lista de alunos reprovados na dsiciplina");
                System.out.print("Digite o numero correspondente: ");

                controle_cli = input.nextInt();
                int qntd;
                if (controle_cli == 1) {
                    ind = false;

                    System.out.println("Digite o codigo da disciplina:");
                    System.out.print("SSC");
                    controle_cod_disciplina = input.nextInt();
                    for (int i = 0; i < disciplinas.size(); i++) {
                        if (disciplinas.get(i).getCod() == controle_cod_disciplina) {
                            ind = true;
                            qntd = disciplinas.get(i).getNumeroAlunosMatriculados();
                            System.out.printf("A disciplina possui: %d alunos matriculados\n", qntd);
                            System.out.print("digite 1 para voltar ao menu:");
                            controle_cli = input.nextInt();
                        }
                    }
                    if (!ind) {
                        System.out.println("Disciplina nao cadastrada");
                        Thread.sleep(2000);

                    }

                }

                if (controle_cli == 2) {
                    ind = false;

                    System.out.println("Digite o codigo da disciplina:");
                    System.out.print("SSC");
                    controle_cod_disciplina = input.nextInt();
                    for (int i = 0; i < disciplinas.size(); i++) {
                        if (disciplinas.get(i).getCod() == controle_cod_disciplina) {
                            ind = true;
                            qntd = disciplinas.get(i).getQntAlunosAprovados();
                            System.out.printf("A disciplina possui: %d alunos aprovados\n", qntd);
                            System.out.print("digite 1 para voltar ao menu:");
                            controle_cli = input.nextInt();
                        }
                    }
                    if (!ind) {
                        System.out.println("Disciplina nao cadastrada");
                        Thread.sleep(2000);

                    }

                }

                if (controle_cli == 3) {
                    ind = false;

                    System.out.println("Digite o codigo da disciplina:");
                    System.out.print("SSC");
                    controle_cod_disciplina = input.nextInt();
                    for (int i = 0; i < disciplinas.size(); i++) {
                        if (disciplinas.get(i).getCod() == controle_cod_disciplina) {
                            ind = true;
                            qntd = disciplinas.get(i).getQntReprovados();
                            System.out.printf("A disciplina possui: %d alunos reprovados\n", qntd);
                            System.out.print("digite 1 para voltar ao menu:");
                            controle_cli = input.nextInt();
                        }
                    }
                    if (!ind) {
                        System.out.println("Disciplina nao cadastrada");
                        Thread.sleep(2000);

                    }


                }

                if (controle_cli == 4) {
                    ind = false;

                    System.out.println("Digite o codigo da disciplina:");
                    System.out.print("SSC");
                    controle_cod_disciplina = input.nextInt();
                    for (int i = 0; i < disciplinas.size(); i++) {
                        if (disciplinas.get(i).getCod() == controle_cod_disciplina) {
                            indice = 1;

                            System.out.println("Qual o numero usp do aluno:");
                            numero_usp = input.nextInt();

                            text_controle_cli = numero_usp;
                            texto_converter = Integer.toString(text_controle_cli);

                            if (texto_converter.length() != 7) {
                                System.out.println("NumeroUsp Invalido");
                                Thread.sleep(2000);
                            } else {
                                if (disciplinas.get(i).lista_alunos.size() == 0) {
                                    System.out.println("Nao ha alunos cadastrados nesta disciplina");

                                } else {
                                    if (disciplinas.get(i).AlunoExiste(numero_usp) == 0) {
                                        controle_aluno_existente = true;
                                        System.out.println("Aluno nao cadastrado nesta disciplina");
                                        Thread.sleep(2000);
                                    } else {
                                    for (int j = 0; j < disciplinas.get(i).lista_alunos.size(); j++) {

                                        if(numero_usp == disciplinas.get(i).lista_alunos.get(j).getNUSP() ){

                                            nota_p1 = disciplinas.get(i).lista_alunos.get(j).getP1();
                                            nota_p2 = disciplinas.get(i).lista_alunos.get(j).getP2();
                                            nota_p3 = disciplinas.get(i).lista_alunos.get(j).getP3();
                                            mediafinal = disciplinas.get(i).lista_alunos.get(j).getMediaFinal();

                                            System.out.printf("As notas do aluno %d sao:\n", numero_usp);
                                            System.out.printf("P1: %d\n", nota_p1);
                                            System.out.printf("P2: %d\n", nota_p2);
                                            System.out.printf("P3: %d\n", nota_p3);
                                            System.out.printf("MF: %f\n", mediafinal);

                                        }



                                        }

                                    }

                                }


                            }


                        }

                    }

                    System.out.print("digite 1 para voltar ao menu:");
                    controle_cli = input.nextInt();


                }

                if (controle_cli == 5) {

                    ind = false;

                    System.out.println("Digite o codigo da disciplina:");
                    System.out.print("SSC");
                    controle_cod_disciplina = input.nextInt();
                    for (int i = 0; i < disciplinas.size(); i++) {
                        if (disciplinas.get(i).getCod() == controle_cod_disciplina) {
                            ind = true;

                            Collections.sort(disciplinas.get(i).lista_alunos, new Comparator<Estudante>() {
                                @Override
                                public int compare(Estudante o1, Estudante o2) {
                                    return Double.compare(o1.getMediaFinal(), o2.getMediaFinal());
                                }
                            });

                            System.out.println("A lista dos alunos e:");
                            for (int j = 0; j < disciplinas.get(i).lista_alunos.size(); j++) {

                                System.out.printf("NUSP: %d  MF: %f\n", disciplinas.get(i).lista_alunos.get(j).getNUSP(), disciplinas.get(i).lista_alunos.get(j).getMediaFinal());


                            }


                            System.out.print("digite 1 para voltar ao menu:");
                            controle_cli = input.nextInt();
                        }
                    }
                    if (!ind) {
                        System.out.println("Disciplina nao cadastrada");
                        Thread.sleep(2000);

                    }


                }

                if (controle_cli == 6) {
                    ind = false;

                    System.out.println("Digite o codigo da disciplina:");
                    System.out.print("SSC");
                    controle_cod_disciplina = input.nextInt();
                    for (int i = 0; i < disciplinas.size(); i++) {
                        if (disciplinas.get(i).getCod() == controle_cod_disciplina) {
                            ind = true;

                            Collections.sort(disciplinas.get(i).lista_alunos, new Comparator<Estudante>() {
                                @Override
                                public int compare(Estudante o1, Estudante o2) {
                                    return Integer.compare(o1.getNUSP(), o2.getNUSP());
                                }
                            });

                            System.out.println("A lista dos alunos e:");
                            for (int j = 0; j < disciplinas.get(i).lista_alunos.size(); j++) {

                                System.out.printf("NUSP: %d  \n", disciplinas.get(i).lista_alunos.get(j).getNUSP());


                            }


                            System.out.print("digite 1 para voltar ao menu:");
                            controle_cli = input.nextInt();
                        }
                    }
                    if (!ind) {
                        System.out.println("Disciplina nao cadastrada");
                        Thread.sleep(2000);

                    }


                }


                if (controle_cli == 7) {

                    ind = false;

                    System.out.println("Digite o codigo da disciplina:");
                    System.out.print("SSC");
                    controle_cod_disciplina = input.nextInt();
                    for (int i = 0; i < disciplinas.size(); i++) {
                        if (disciplinas.get(i).getCod() == controle_cod_disciplina) {
                            ind = true;


                            System.out.println("A lista dos alunos aprovados e:");
                            for (int j = 0; j < disciplinas.get(i).lista_alunos.size(); j++) {
                                if (disciplinas.get(i).lista_alunos.get(j).getAprovacao()) {

                                    System.out.printf("NUSP: %d  MF: %f\n", disciplinas.get(i).lista_alunos.get(j).getNUSP(),disciplinas.get(i).lista_alunos.get(j).getMediaFinal());

                                }


                            }


                            System.out.print("digite 1 para voltar ao menu:");
                            controle_cli = input.nextInt();
                        }
                    }
                    if (!ind) {
                        System.out.println("Disciplina nao cadastrada");
                        Thread.sleep(2000);

                    }


                }


                if (controle_cli == 8) {


                    ind = false;

                    System.out.println("Digite o codigo da disciplina:");
                    System.out.print("SSC");
                    controle_cod_disciplina = input.nextInt();
                    for (int i = 0; i < disciplinas.size(); i++) {
                        if (disciplinas.get(i).getCod() == controle_cod_disciplina) {
                            ind = true;


                            System.out.println("A lista dos alunos reprovados e:");
                            for (int j = 0; j < disciplinas.get(i).lista_alunos.size(); j++) {
                                if (!disciplinas.get(i).lista_alunos.get(j).getAprovacao()) {

                                    System.out.printf("NUSP: %d  MF: %f\n", disciplinas.get(i).lista_alunos.get(j).getNUSP(),disciplinas.get(i).lista_alunos.get(j).getMediaFinal());

                                }


                            }


                            System.out.print("digite 1 para voltar ao menu:");
                            controle_cli = input.nextInt();
                        }

                    }


                    //consultas
                }


                for (int i = 0; i < 50; ++i) System.out.println();
            }

        }

    }
}
