
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Curso> cursos = new ArrayList();
        int opc = 0;
        int codigo, cargaHoraria;
        String nome, ra, msg = null;

        while (opc != 6) {
            opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Criar curso\n"+ "2 - Criar aluno\n"+ "3 - Remover aluno\n"+ "4 - Mostrar todos os cursos\n"+ "5 - Mostrar alunos do curso\n"+ "6 - Sair"));
            Curso cursoSelecionado = null;
            if (opc == 2 || opc == 3 || opc == 5) {
                String mensagem = "Escolha o código de um dos cursos abaixo: \n";
                for(Curso curso: cursos){
                    mensagem = mensagem+curso.imprimir()+"\n";
                }
                int CodigoCursoSelecionado = Integer.parseInt(JOptionPane.showInputDialog(null, mensagem));
                for(Curso curso: cursos){
                    if(curso.getCodigo() == CodigoCursoSelecionado){
                        cursoSelecionado = curso;
                    }
                }
                
                if(cursoSelecionado == null){
                    JOptionPane.showMessageDialog(null, "O codigo escolhido não corresponde à nenhum curso cadastrado");
                    continue;
                }
            }

            switch (opc) {
                case 1:
                    codigo = Integer.parseInt(JOptionPane.showInputDialog("Código: "));
                    nome = JOptionPane.showInputDialog("Nome: ");
                    cargaHoraria = Integer.parseInt(JOptionPane.showInputDialog("Carga Horaria: "));
                    cursos.add(new Curso(codigo, nome, cargaHoraria));
                    break;

                case 2:
                    ra = JOptionPane.showInputDialog("RA: ");
                    nome = JOptionPane.showInputDialog("Nome: ");
                    cursoSelecionado.inserirAluno(new Aluno(ra, nome));
                    break;

                case 3:
                    ra = JOptionPane.showInputDialog("Selecione um aluno por RA:\n"
                            + cursoSelecionado.imprimirCompleto());

                    for (Aluno aluno : cursoSelecionado.getAlunos()) {
                        if (aluno.getRa().equals(ra)) {
                            cursoSelecionado.removerAluno(aluno);
                        }
                    }

                    break;

                case 4:
                    for (Curso curso : cursos) {
                        msg += curso.imprimir() + "\n";
                    }
                    
                    JOptionPane.showMessageDialog(null, msg);
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, cursoSelecionado.imprimirCompleto());
                    break;
            }

        }
    }
}
