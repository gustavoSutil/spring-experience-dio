package exceptions;

public class NoVolumError extends Exception{
    public NoVolumError() throws Exception{
        throw new Exception("Erro nenhum volume encontrado");
    }
}
