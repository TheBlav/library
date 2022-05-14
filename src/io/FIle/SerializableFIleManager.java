package io.FIle;

import Exceptions.DataExportException;
import Exceptions.DataImportException;
import model.Library;

import java.io.*;

public class SerializableFIleManager implements  FileManager{
    private static final String FILE_NAME = "Library.o";

    @Override
    public Library importData() {
        try(
                var fis = new FileInputStream(FILE_NAME);
                var ois = new ObjectInputStream(fis);
                ){
                   return (Library) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new DataImportException("Nie znaleziono pliku: " + FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("Błąd wczytania pliku: " + FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new DataImportException("Niezgodny typ danych w pliku: " + FILE_NAME);
        }
    }

    @Override
    public void exportData(Library library) {

        try(
                var fos = new FileOutputStream(FILE_NAME);
                var oos = new ObjectOutputStream(fos);
                ) {
            oos.writeObject(library);
        }
        catch (FileNotFoundException e){
            throw new DataExportException("Brak pliku " + FILE_NAME);
        }
        catch (IOException e) {
            throw new DataExportException("Błąd zapisu danych do pliku " + FILE_NAME);
        }
    }


}
