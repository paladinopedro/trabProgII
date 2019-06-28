package trabalho;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;


public class Locacao {
    private Date DataLocacao;
    private String NomeResponsavel;
    private String CPFResponsavel;
    private int Diarias;
    private String Tanque;
    private Veiculo veiculo;
    private double ValorTotal;
    int setDiarias;
    double setValorTotal;

    public Date getDataLocacao() {
        return DataLocacao;
    }

    public void setDataLocacao(Date DataLocacao) {
        this.DataLocacao = DataLocacao;
    }

    public String getNomeResponsavel() {
        return NomeResponsavel;
    }

    public void setNomeResponsavel(String NomeResponsavel) {
        this.NomeResponsavel = NomeResponsavel;
    }

    public String getCPFResponsavel() {
        return CPFResponsavel;
    }

    public void setCPFResponsavel(String CPFResponsavel) {
        this.CPFResponsavel = CPFResponsavel;
    }

    public int getDiarias() {
        return Diarias;
    }

    public void setDiarias(int Diarias) {
        this.Diarias = Diarias;
    }

    public String getTanque() {
        return Tanque;
    }

    public void setTanque(String Tanque) {
        this.Tanque = Tanque;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String vel, ArrayList<Veiculo> listaveiculo) {
        for(int i = 0; i < listaveiculo.size(); i++){
            if(listaveiculo.get(i).getClasse().equalsIgnoreCase(vel)){
                this.veiculo = listaveiculo.get(i);
                JOptionPane.showMessageDialog(null, veiculo.getClasse());
            }else{
                JOptionPane.showMessageDialog(null, "ERRO");
            }
        }
        
    }

    public double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }
    
    public double CalcValorLocacao(){
    
        if(this.veiculo.getClasse().equals("Economica")){
            return Diarias * 100; 
        }
        else if(this.veiculo.getClasse().equals("Intermediaria")){
            return Diarias * 150;
        }
        else if(this.veiculo.getClasse().equals("Executivo")){
            return Diarias * 200;
        }
        else if(this.veiculo.getClasse().equals("Luxo")){
            return Diarias * 400;
        }
     return 0;               
    }

    void getCPFResponsavel(String showInputDialog) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
