import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BackupService {
    
    public void saveUsers (List<User> users, String filePath) throws IOException {
        try (
                FileOutputStream fos = new FileOutputStream(filePath);
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            
            for (User user : users) {
                oos.writeObject(user);
            }
            
            IO.println("Users written to: " + filePath + "\n");
        }
        catch (IOException e) {
            System.err.println("Error writing users to file: " + e.getMessage());
            throw e;
        }
    }
    
    public List<User> loadUsers (String filePath) {
        List<User> users = new ArrayList<>();
        
        try (
                FileInputStream fis = new FileInputStream(filePath);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            while (true) {
                try {
                    User user = (User) ois.readObject();
                    users.add(user);
                }
                catch (EOFException e) {
                    break;
                }
            }
            
            IO.println("Loaded " + users.size() + " users from: " + filePath);
        }
        catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        }
        catch (IOException e) {
            System.err.println("Error reading users from file: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.err.println("User class not found: " + e.getMessage());
        }
        
        return users;
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public void backupFile (Path sourceFile, Path backupDir) {
        try {
            Files.createDirectories(backupDir);
            
            Path backupFile = backupDir.resolve(sourceFile.getFileName());
            
            if (Files.exists(backupFile)) {
                Files.delete(backupFile);
            }
            
            Files.copy(sourceFile, backupFile);
            
            IO.println("\nFile copied to backup: " + backupFile);
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void deleteBackup (Path backupFilePath) throws IOException {
        try {
            Files.delete(backupFilePath);
            IO.println("\nFile deleted from: " + backupFilePath);
        } catch (IOException e) {
            System.err.println("Error deleting file: " + e.getMessage());
            throw e;
        }
    }
}