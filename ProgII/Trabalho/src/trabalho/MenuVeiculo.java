package trabalho;

import java.util.ArrayList;
import javax.swing.JOptionPane;



 
        
public class MenuVeiculo {
    public static int TelaOpcaoVeiculo(ArrayList<Veiculo> listaveiculo)
    {
        int retorno = 0;
        String opcao;
        boolean loop = true;
        
        while(loop){
            opcao = JOptionPane.showInputDialog(null,
                    "Escolha uma das opções: \n" +
                  "1 - Cadastro de Veiculos \n" +
                  "2 - Alterar Veiculo \n" +
                  "3 - Excluir veiculo \n" +
                  "4 - Consultar/Listar Veiculos \n"+
                  "5 - Voltar", "Menu Principal", 1);
            if (opcao == null){
                JOptionPane.showMessageDialog(null, "Escolha uma Opção", "Atenção", 0);
            }
            else if (opcao.equals("1")) {
                listaveiculo.add(CadVeiculo());
            }
            else if (opcao.equals("2")) {
                AltVeiculo(listaveiculo);
            }
            else if (opcao.equals("3")) {
                ExcluirVeiculo(listaveiculo);
            }
            else if (opcao.equals("4")){
                ListaVeiculo(listaveiculo);
            }            
            else if (opcao.equals("5")) {
                loop = false;
            }
            else{
                JOptionPane.showMessageDialog(null, "Opção inválida", "Atenção", 0);
            }
           
        }
        return retorno;
    }
    private static Veiculo CadVeiculo(){
        Veiculo v = new Veiculo();
        v.setChassi(JOptionPane.showInputDialog(null, "Digite o chassi do Veiculo:", "Cadastro veiculo", 3));
        v.setMarca(JOptionPane.showInputDialog(null, "Digite o marca do Veiculo:", "Cadastro veiculo", 3));
        v.setModelo(JOptionPane.showInputDialog(null, "Digite o modelo do Veiculo:", "Cadastro veiculo", 3));
        String ano = (JOptionPane.showInputDialog(null, "Digite o ano do Veiculo:", "Cadastro veiculo", 3));
        v.setAno(Integer.parseInt(ano));
        v.setClasse(JOptionPane.showInputDialog(null, "Digite a classe do Veiculo: Economica, Intermediario, Executivo ou Luxo", "Cadastro veiculo", 3));
        String qntLitros = (JOptionPane.showInputDialog(null, "Digite a quantidade de litros do tanque do Veiculo:", "Cadastro veiculo", 3));
        v.setQtdLitrosTanque(Integer.parseInt(qntLitros));
        return v;
    }
    public static void AltVeiculo(ArrayList<Veiculo> listaveiculo){
        String nomeveiculo = JOptionPane.showInputDialog(null, "Digite o chassi do veiculo", "Alterar cadastro de veiculo", 3);
        if(nomeveiculo != null){
            for (int i = 0; i < listaveiculo.size();i++){
                if (listaveiculo.get(i).getChassi().equals(nomeveiculo))
                {
                    Veiculo v = listaveiculo.get(i);
                    v.setChassi((String) JOptionPane.showInputDialog( null , "Digite o chassi do Veiculo",
                    "Alterar Cadastro de Veicullos",JOptionPane.QUESTION_MESSAGE , null , null , v.getChassi()));
                    v.setMarca((String) JOptionPane.showInputDialog(null, "Digite a marca do veiculo",
                    "Alterar Cadastro de Veiculos", JOptionPane.QUESTION_MESSAGE, null, null, v.getMarca()));
                    v.setModelo((String) JOptionPane.showInputDialog(null, "Digite o modelo do veiculo",
                    "Alterar Cadastro de Veiculos", JOptionPane.QUESTION_MESSAGE, null, null, v.getModelo()));
                    
                    String ano = (String) JOptionPane.showInputDialog( null , "Digite o ano do veiculo",
                    "Alterar Cadastro de Veiculo",JOptionPane.QUESTION_MESSAGE , null , null , v.getAno());
                    v.setAno(Integer.parseInt(ano));
                    v.setClasse((String) JOptionPane.showInputDialog(null, "Digite a classe do veiculo",
                    "Alterar Cadastro de Veiculos", JOptionPane.QUESTION_MESSAGE, null, null, v.getClasse()));
                    String qntLitro = (String) JOptionPane.showInputDialog( null , "Digite quantidade litros do veiculo",
                    "Alterar Cadastro de Veiculo",JOptionPane.QUESTION_MESSAGE , null , null , v.getQtdLitrosTanque());
                    v.setQtdLitrosTanque(Integer.parseInt(qntLitro));
                }
            }
        }
    }
   
    public static void ExcluirVeiculo(ArrayList<Veiculo> lista) {
        String chassi = JOptionPane.showInputDialog(null, "Digite o chassi do Veiculo", "Excluir Cadastro de Veiculo", 3);
        if (chassi != null) {
            for (int i = 0; i < lista.size(); i++)
            {
                if (lista.get(i).getChassi().equals(chassi))
                {
                lista.remove(i);
                JOptionPane.showMessageDialog(null,"O Cadastro do Veiculo " + chassi + " foi excluido" ,
                "Excluir Cadastro de Veiculo", 3);
            break;
                }
            
            }
        }
    }
    
    public static void ListaVeiculo(ArrayList<Veiculo> lista)
    {
    String ListaVeiculo = "";
    for (int i = 0; i < lista.size(); i++) {
        ListaVeiculo += "Chassi " + lista.get(i).getChassi() + " - " + "Marca " + lista.get(i).getMarca() + " - " +
        "Modelo: " + lista.get(i).getModelo() + "-" + "Ano" + lista.get(i).getAno() + " - " + "Classe"+lista.get(i).getClasse() +"\n";
        }
        JOptionPane.showMessageDialog(null, ListaVeiculo, "Veiculos cadastrados", 3);
    }
}
