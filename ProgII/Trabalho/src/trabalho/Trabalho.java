
package trabalho;

import trabalho.Locacao;
import trabalho.Veiculo;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Trabalho {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
       ArrayList<Veiculo> listaveiculo = new ArrayList<>();
       ArrayList<Locacao> listalocacao = new ArrayList<>();
       
       String opcao;
       boolean loop = true;
       while (loop) {
           opcao = JOptionPane.showInputDialog(null,
                   "Escolha Uma das Opções: \n"
                    +"1- Veiculos \n"
                    +"2- Locação \n"
                    +"3- Sair", "Menu Principal", 1);
           if (opcao == null) {
                JOptionPane.showMessageDialog(null,"Escolha uma Opção", "Atenção", 0);
            }
            else if (opcao.equals("1")) {
                MenuVeiculo.TelaOpcaoVeiculo(listaveiculo);
            }
            else if (opcao.equals("2")){
                MenuLocacao.MenuLocacao1(listalocacao, listaveiculo);
            }
            else if(opcao.equals("3")){
                break;
                
            }
       }     
    }
    }
