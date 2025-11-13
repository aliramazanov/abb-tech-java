import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "ExplicitToImplicitClassMigration", "RedundantSuppression" })
public class Practice {
    
    static void main () throws IOException {
        
        BackupService service = new BackupService();
        List<User> users = new ArrayList<>();
        
        users.add(new User("UserOne", "uone@mail.com", 28));
        users.add(new User("UserTwo", "utwo@mail.com", 25));
        users.add(new User("UserThree", "uthree@mail.com", 27));
        
        Path dataFile = Path.of("src/users.dat");
        Path backupDir = Path.of("src/backup");
        Path backupFilePath = backupDir.resolve(dataFile.getFileName());
        
        System.out.println("-> User Data backup Service <-\n");
        service.saveUsers(users, String.valueOf(dataFile));
        
        List<User> loadedUsers = service.loadUsers(String.valueOf(dataFile));
        System.out.println("\nLoaded Users: ");
        loadedUsers.forEach(System.out::println);
        
        service.backupFile(dataFile, backupDir);
        //service.deleteBackup(backupFilePath);
        
        System.out.println("\n-> Process Completed <-");
    }
}
