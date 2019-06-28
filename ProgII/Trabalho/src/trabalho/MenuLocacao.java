package trabalho;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import trabalho.Locacao;
import trabalho.Veiculo;

public class MenuLocacao {

    private static Object listaveiculo;

    public static int MenuLocacao1(ArrayList<Locacao> listalocacao, ArrayList<Veiculo> listaveiculo) throws ParseException {
        
        String opcao;
        boolean loop = true;
        while (loop) {
            opcao = JOptionPane.showInputDialog(null,
                    "Escolha uma Opção: \n"
                    + "1- Nova Locação: \n"
                    + "2- Alterar Locação: \n"
                    + "3- Excluir Locação: \n"
                    + "4- Consultar Locação: \n"
                    + "5- Encerrar Locação: \n"
                    + "6- Listar Locação Por Mês: \n"
                    + "7- Listar Todas as Locações: \n"
                    + "8- Voltar", "Menu Locação", 1);
            if (opcao.equals("1")) {
                listalocacao.add(CadastrarLocacao(listalocacao, listaveiculo));
            } else if (opcao.equals("2")) {
                AlterarLocacao(listalocacao, listaveiculo);
            } else if (opcao.equals("3")) {
                ExcluirLocacao(listalocacao);
            } else if (opcao.equals("4")) {
                ConsultarLocacao(listalocacao);
            } else if (opcao.equals("5")) {
                EncerrarLocacao(listalocacao);
            } else if (opcao.equals("6")) {
                ListarLocacaoMes(listalocacao);
            } else if (opcao.equals("7")) {
                ListarLocacao(listalocacao);
            } else if (opcao.equals("8")) {
                loop = false;
            } else {
                JOptionPane.showMessageDialog(null, "Opção inválida", "Atenção", 0);
            }
        }
        return 0;
    }

    public static Locacao CadastrarLocacao(ArrayList<Locacao> listaloacao, ArrayList<Veiculo> veiculo) throws ParseException {
        Locacao l = new Locacao();
        
        String DataLocacao = JOptionPane.showInputDialog(null, "Digite a Data de Locação dd/mm/aaaa", "Cadastro Locação", 3);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        l.setDataLocacao(formato.parse(DataLocacao));

        l.setNomeResponsavel(JOptionPane.showInputDialog(null, "Digite o Nome do Responsável: ", "Cadastro Locação", 3));
        l.setCPFResponsavel(JOptionPane.showInputDialog(null, "Digite o CPF do Responsável: ", "Cadastro Locação", 3));
        String Diarias = (JOptionPane.showInputDialog(null, "Digite os Dias (Diárias): "));
        l.setDiarias(Integer.parseInt(Diarias));
        // l.setTanque(JOptionPane.showInputDialog(null, "Digite como Esta o Tanque: ", "Cadastro Locação", 3));
        String te = (JOptionPane.showInputDialog(null, "Digite a classe do seu veiculo: Economica, Intermediario, Executivo ou Luxo", "Cadastro Locação", 3));
        l.setVeiculo(te, veiculo);
        String Total = (JOptionPane.showInputDialog(null, "Digite o Valor Total: ", "Cadastro Locação", 3));
        l.setValorTotal(Double.parseDouble(Total));
        
        //l.setVeiculo(veiculo);

        return l;

    }

    public static void AlterarLocacao(ArrayList<Locacao> listalocacao, ArrayList<Veiculo> listaveiculo) throws ParseException {
        String CPFResponsavel = JOptionPane.showInputDialog(null, "Digite o CPF do Responsável: ", "Alteração da Locação", 3);
        if (CPFResponsavel != null) {
            for (int i = 0; i < listalocacao.size(); i++) {
                if (listalocacao.get(i).getCPFResponsavel().equals(CPFResponsavel)) {
                    Locacao l = listalocacao.get(i);

                    String DataLocacao = JOptionPane.showInputDialog(null, "Digite a Data de Locação dd/mm/aaaa", "Alteração da Locação", 3);
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");                 
                    l.setDataLocacao(formato.parse(DataLocacao));
                    l.setNomeResponsavel(JOptionPane.showInputDialog(null, "Digite o Nome do Responsável: ", "Alteração da Locação", 3));
                    l.setCPFResponsavel(JOptionPane.showInputDialog(null, "Digite o CPF do Responsálvel:", "Alteração da Locação", 3));
                    String Diaria = JOptionPane.showInputDialog(null, "Digite a Diária:", "Alteração da Locação", 3);
                    l.setDiarias(Integer.parseInt(Diaria));
                    //l.setTanque(JOptionPane.showInputDialog(null,"Digite a Quantidade do Tanque:", "Alteração da Locação",3));
                    String Total = (JOptionPane.showInputDialog(null, "Digite o Valor Total: ", "Cadastro Locação", 3));
                    l.setValorTotal(Double.parseDouble(Total));

                    listalocacao.set(i, l);
                }
            }
        }
    }

    public static void ExcluirLocacao(ArrayList<Locacao> listalocacao) {
        String CPFResponsavel = JOptionPane.showInputDialog(null, "Digite o CPF do Responsável: ", "Excluir Locação", 3);
        if (CPFResponsavel != null) {
            for (int i = 0; i < listalocacao.size(); i++) {
                if (listalocacao.get(i).getCPFResponsavel().equals(CPFResponsavel)) {
                    listalocacao.remove(i);
                    JOptionPane.showMessageDialog(null, "A Locação do Responsável " + CPFResponsavel + "foi excluido ", "Excluir Locação", 3);
                    break;
                }
            }
        }
    }

    public static void ConsultarLocacao(ArrayList<Locacao> listalocacao) {
        String CPFResponsavel = JOptionPane.showInputDialog(null, "Digite o CPF do Responsável: ", "Consultar Locação", 3);
        if (CPFResponsavel != null) {
            for (int i = 0; i < listalocacao.size(); i++) {
                if (listalocacao.get(i).getCPFResponsavel().equals(CPFResponsavel)) {
                    JOptionPane.showMessageDialog(null,
                            "Data Locação: " + listalocacao.get(i).getDataLocacao() + "\n"
                            + "Nome do Responsável: " + listalocacao.get(i).getNomeResponsavel() + "\n"
                            + "CPF do Responsável: " + listalocacao.get(i).getCPFResponsavel() + "\n"
                            + "Diárias: " + listalocacao.get(i).getDiarias() + "\n"
                            + "Tanque: " + listalocacao.get(i).getTanque() + "\n"
                            + "Veiculo: " + listalocacao.get(i).getVeiculo() + "\n"
                            + "Valor Total: " + listalocacao.get(i).getValorTotal(), "Consultar Locação", 3);
                }
            }
        }
    }

    public static void EncerrarLocacao(ArrayList<Locacao> listalocacao) {
        Locacao a = new Locacao();
        Locacao d;
        Veiculo b = new Veiculo();
        String CPFResponsavel = JOptionPane.showInputDialog(null, "Digite o CPF do Responsável: ", "Consultar Locação", 3);
        if(CPFResponsavel != null){
            for (int i = 0; i < listalocacao.size(); i++) {
                  d = listalocacao.get(i);
                if (d.getCPFResponsavel().equals(CPFResponsavel)){
                    JOptionPane.showMessageDialog(null,"Valor total a pagar:" + d.CalcValorLocacao());
                    listalocacao.remove(i);
                    JOptionPane.showMessageDialog(null, "A Locação do Responsável " + CPFResponsavel + " foi excluido ", "Excluir Locação", 3);
                    break;
                }
            } 
        }   
    }

    public static void ListarLocacaoMes(ArrayList<Locacao> listalocacao) {
        Object[] opcoesmeses = {"janeiro", "fevereiro", "março", "abril", "maio", "junho",
            "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"};
        int opcao = JOptionPane.showOptionDialog(null, "Escolha o Mês", "Mês de Locação", 0, 1, null, opcoesmeses, "");
        opcao++;

        SimpleDateFormat formato = new SimpleDateFormat("MM");
        int mes = 0;
        Locacao l;
        String locacao = "";
        for (int i = 0; i < listalocacao.size(); i++) {
            l = listalocacao.get(i);
            mes = Integer.parseInt(formato.format(l.getDataLocacao()));

            if (mes == opcao) {
                locacao += listalocacao.get(i).getNomeResponsavel() + " - " + listalocacao.get(i).getCPFResponsavel() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, locacao, "Relatório de Locação", 1);
    }

    public static void ListarLocacao(ArrayList<Locacao> listalocacao) {
        String ListaLocacao = "";
        for (int i = 0; i < listalocacao.size(); i++) {
            ListaLocacao += "Data Locação " + listalocacao.get(i).getDataLocacao() + " - "
                    + " Nome Responsável " + listalocacao.get(i).getNomeResponsavel() + " - "
                    + "CPF do Responsável " + listalocacao.get(i).getCPFResponsavel() + " - "
                    + "Diárias " + listalocacao.get(i).getDiarias() + " - "
                    + "Tanque do Veículo " + listalocacao.get(i).getTanque() + " - "
                    + "Veículo " + listalocacao.get(i).getVeiculo() + " - "
                    + "Valor Total " + listalocacao.get(i).getValorTotal() + "\n";
        }
        JOptionPane.showMessageDialog(null, ListaLocacao, "Locações Cadastradas", 3);
    }
}
