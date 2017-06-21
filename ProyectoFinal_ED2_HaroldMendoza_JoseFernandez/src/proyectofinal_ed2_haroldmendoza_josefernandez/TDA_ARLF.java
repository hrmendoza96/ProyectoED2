package proyectofinal_ed2_haroldmendoza_josefernandez;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;


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
        try {
            while(true){
                if(AvailList.isEmpty()){
                    flujo.seek(archivo.length());
                    flujo.writeInt(persona.getId());
                    flujo.writeUTF(persona.getName());
                    flujo.writeUTF(persona.getBirthDate());
                    flujo.writeFloat(persona.getSalary());
                    System.out.println("Hola");
                    return true;
                }else{
                    int p = (int) AvailList.remove(0);
                    flujo.seek(sizeOfRecord*(p-1));
                    flujo.writeInt(persona.getId());
                    flujo.writeUTF(persona.getName());
                    flujo.writeUTF(persona.getBirthDate());
                    flujo.writeFloat(persona.getSalary());
                    System.out.println("Hola2");
                    return true;
                    
                }
            }
        } catch (EOFException e) {
            
        }  
        return false;
    }//fin insert
    
    public void listar(){
        Person persona = new Person();
        try {
            while(true){
                persona.setId(flujo.readInt());
                persona.setName(flujo.readUTF());
                persona.setBirthDate(flujo.readUTF());
                persona.setSalary(flujo.readFloat());
                System.out.println(persona.toString());
            }
        } catch (Exception e) {
        }
    }
    
    
    
    
}
