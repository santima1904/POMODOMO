package es.iesnervion.smartinez.practica_android_1t.clasesBasicas;

public class EmpresaNoTecnologica extends Empresa{
    //Atributos
    private String cnae;

    //Constructor
    //Con parámetros
    public EmpresaNoTecnologica(String nombre, String cnae) {
        super(nombre);
        this.cnae = cnae;
    }

    //Por defecto
    public EmpresaNoTecnologica() {
        super(" ");
        this.cnae = " ";
    }

    //Getters and setters
    public String getCnae() {
        return cnae;
    }

    public void setCnae(String cnae) {
        this.cnae = cnae;
    }
}
