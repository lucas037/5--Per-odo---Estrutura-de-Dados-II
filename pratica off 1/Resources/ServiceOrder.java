package Resources;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ServiceOrder {
    private int id;
    private String nome;
    private String descricao;
    private String dataSolicitacao;
    private String horaSolicitacao;
    private static int countId = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao.charAt(descricao.length() - 1) != '.') {
            descricao += ".";
        }

        this.descricao = descricao;
    }

    public String getHoraSolicitacao() {
        return horaSolicitacao;
    }

    public void setHoraSolicitacao(String horaSolicitacao) {
        this.horaSolicitacao = horaSolicitacao;
    }
    
    public String getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(String dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public static int getCountId() {
        return ++countId;
    }

    public static void setCountId(int countId) {
        ServiceOrder.countId = countId;
    }

    public ServiceOrder(String nome, String descricao) {
        this.id = getCountId();
        setNome(nome);
        setDescricao(descricao);
        setDataSolicitacao(getData());
        setHoraSolicitacao(getHora());
    }

    public ServiceOrder(String nome, String descricao, String data, String hora) {
        setId(getCountId());
        setNome(nome);
        setDescricao(descricao);
        setDataSolicitacao(data);
        setHoraSolicitacao(hora);
    }

    private String getData() {
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return hoje.format(formato);
    }

    private String getHora() {
        LocalTime agora = LocalTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        return agora.format(formato);
    }

    public String toString() {
        String str = "";

        str += id+": ";
        str += dataSolicitacao+", "+horaSolicitacao+". ";
        str += nome+". ";
        str += descricao;
         
        return str;
    }
}
