package extension.temporary_folder;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.File;
import java.io.IOException;

// 临时目录用于在单元测试时提供测试目录
// - 在测试前创建出测试目录
// - 在测试后清除测试目录
public class TemporaryFolderExtension implements BeforeEachCallback, AfterEachCallback {

    private final File parentFolder;
    private File folder;

    public TemporaryFolderExtension() {
        this(null);
    }

    public TemporaryFolderExtension(File parentFolder) {
        this.parentFolder = parentFolder;
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        try {
            folder = File.createTempFile("junit", "", parentFolder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        folder.delete();
        folder.mkdir();
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        if (folder != null) {
            recursiveDelete(folder);
        }
    }

    private void recursiveDelete(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File each : files) {
                recursiveDelete(each);
            }
        }
        file.delete();
    }

    public File newFolder(String folderName) {
        File file = getRoot();
        file = new File(file, folderName);
        file.mkdir();
        return file;
    }

    public File getRoot() {
        if (folder == null) {
            throw new IllegalStateException("the temporary folder has not yet been created");
        }
        return folder;
    }

    public File newFile(String fileName) throws IOException {
        File file = new File(getRoot(), fileName);
        if (!file.createNewFile()) {
            throw new IOException("a file with the name \'" + fileName + "\' already exists in the test folder");
        }
        return file;
    }
}
