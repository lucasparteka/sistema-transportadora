package dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializador {

    //Método responsável por serializar qualquer objeto em seu devido lugar
    //Por isso é passado como paramêtro o objeto, o caminho que é pra ser salvo o arquivo e o nome de identificação do mesmo
    public void serializarObjeto(Object obj, File caminho) {
        //File file = new java.io.File("src\\" + caminho);
        ObjectOutputStream objGravar = null;
        FileOutputStream arquivoGrav = null;
        
        try {
            arquivoGrav = new FileOutputStream(caminho);
            objGravar = new ObjectOutputStream(arquivoGrav);
            objGravar.writeObject(obj);
            objGravar.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (objGravar != null) {
                    objGravar.close();
                }
                if (arquivoGrav != null) {
                    arquivoGrav.close();
                }
            } catch (IOException e) {
                System.out.println("Erro ao fechar arquivo");
            }
        }
    }
}
