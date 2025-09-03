package javaapplication1.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Modelo de Cliente com validação, métodos utilitários e pronto para frameworks.
 * 
 * @author William Tôrres
 */
public final class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private Long cpf;
    private Long tel;
    private String end;
    private Integer numero;
    private String cidade;
    private String estado;

    // Construtor vazio: usado por frameworks, serialização e facilidade de manipulação
    public Cliente() {
    }

    /**
     * Construtor completo com validação.
     * @param nome
     * @param cpf
     * @param tel
     * @param end
     * @param num
     * @param cidade
     * @param estado
     */
    public Cliente(String nome, String cpf, String tel, String end, String num, String cidade, String estado) {
        this.nome = nome;
        setCpfString(cpf);
        setTelString(tel);
        this.end = end;
        setNumeroString(num);
        this.cidade = cidade;
        this.estado = estado;
    }

    // GETTERS E SETTERS

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }
    
    public String getCpfString() {
    // %011d: formata o número com zeros à esquerda até 11 dígitos
    return String.format("%011d", this.cpf);
    }
    
    public void setCpfString(String cpf) {
    if (cpf == null || cpf.trim().isEmpty()) {
        throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
    }
    
    // Remove tudo que não for dígito
    String cpfLimpo = cpf.replaceAll("\\D", "");
    // Se tiver 10 dígitos, acrescenta um zero à esquerda
    if (cpfLimpo.length() == 10) {
        cpfLimpo = "0" + cpfLimpo;
    }
    
    // Deve ter exatamente 11 dígitos agora
    if (cpfLimpo.length() != 11) {
        throw new IllegalArgumentException(
            "CPF deve ter 11 dígitos após limpar formatação. Recebido: " + cpf
        );
    }
    
    // Converte finalmente para Long (mantendo zeros à esquerda via string)
    this.cpf = Long.valueOf(cpfLimpo);
}

    /**
     * Validação interna: só aceita exatamente 11 dígitos numéricos.
     */
    private boolean isValidCPF(Long cpf) {
    if (cpf == null) return false;
    String cpfStr = String.format("%011d", cpf); 
    // %011d garante zero padding até 11 dígitos
    return Pattern.matches("\\d{11}", cpfStr);
}

    public void setCpf(Long cpf) {
    if (!isValidCPF(cpf)) {
        throw new IllegalArgumentException("CPF inválido: " + String.format("%011d", cpf));
    }
    this.cpf = cpf;
}

    public Long getTel() {
        return tel;
    }
    public void setTel(Long tel) {
        if (tel == null || tel <= 0) {
            throw new IllegalArgumentException("Telefone inválido: " + tel);
        }
        this.tel = tel;
    }
    public void setTelString(String tel) {
        setTel(Long.valueOf(tel));
    }

    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        if (numero == null || numero <= 0) {
            throw new IllegalArgumentException("Número do endereço inválido: " + numero);
        }
        this.numero = numero;
    }
    public void setNumeroString(String num) {
        setNumero(Integer.valueOf(num));
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // EQUALS/HASHCODE BASEADO NO CPF
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente other = (Cliente) obj;
        return Objects.equals(this.cpf, other.cpf);
    }

    // REPRESENTAÇÃO TEXTO: ÚTIL PARA DEBUG E LOGS
    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", cpf=" + cpf + ", tel=" + tel
                + ", end=" + end + ", numero=" + numero + ", cidade=" + cidade
                + ", estado=" + estado + "]";
    }
}
