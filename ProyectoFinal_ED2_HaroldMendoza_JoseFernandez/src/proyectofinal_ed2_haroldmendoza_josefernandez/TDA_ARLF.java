/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal_ed2_haroldmendoza_josefernandez;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;

/**
 *
 * @author Harold Mendoza
 */
public class TDA_ARLF {
    
    private File archivo;
    private RandomAccessFile flujo;
    private final int sizeOfRecord = Integer.BYTES+Character.BYTES+40+Character.BYTES+10+Float.BYTES;
    private final int sizeOfHeader = Integer.BYTES;
    private LinkedList AvailList = new LinkedList();

    public TDA_ARLF(File archivo) {
        this.archivo = archivo;
        try {
            flujo = new RandomAccessFile(archivo, "rw");
        } catch (Exception e) {
            System.out.println("Archivo no existe");
        }
        
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public RandomAccessFile getFlujo() {
        return flujo;
    }

    public void setFlujo(RandomAccessFile flujo) {
        this.flujo = flujo;
    }
    
    public void close(){
        try {
            flujo.close();
        } catch (Exception e) {
        }
    }
    
    public boolean insert(Person persona) throws IOException{
        boolean created = false;
        try {
            while(true){
                if(AvailList.isEmpty()){
                    flujo.seek(archivo.length());
                }else{
                    int p = (int) AvailList.remove(0);
                    flujo.seek(sizeOfRecord*(p-1));
                    flujo.write(persona.getId());
                    flujo.writeUTF(persona.getName());
                    flujo.writeUTF(persona.getBirthDate());
                    flujo.writeFloat(persona.getSalary());
                    created = true;
                    
                }
            }
        } catch (EOFException e) {
            
        }  
        return created;
    }//fin insert
    
    
    
    
}
