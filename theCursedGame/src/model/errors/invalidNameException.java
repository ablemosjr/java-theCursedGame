package model.errors;

/** Erro para validação de nome do personagem
 * - Nome nulos ou vazios não são aceitos
 * 
 * @author Alessandro Bonfilio de Lemos Junior - RA 1601018
 * @since 29/09/2022
 */
public class invalidNameException extends Exception {

    private String name;

    public invalidNameException(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Nome inválido! Favor tentar novamente.";
    }
}
