package in.parangat.a3charger.Helper;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DownloadFile {
    Context context;
    String fileUrl;

    public DownloadFile(Context context, String fileUrl) {
        this.context = context;
        this.fileUrl = fileUrl;
    }

    public DownloadFile(Context context) {
        this.context=context;
    }

    public class DownloadPdfFiles extends AsyncTask<String, String, String>
    {
        private ProgressDialog progressDialog;
        private String fileName;
        private String folder;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            this.progressDialog = new ProgressDialog(context);
            this.progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            this.progressDialog.setMessage("Downloading..");
            this.progressDialog.setCancelable(false);
            this.progressDialog.show();
        }
        @Override
        protected String doInBackground(String... f_url) {
            int count;
            try {
                URL url = new URL(f_url[0]);
                URLConnection connection = url.openConnection();
                connection.connect();
                int lengthOfFile = connection.getContentLength();
                InputStream input = new BufferedInputStream(url.openStream(), 8192);

                fileName = fileUrl;
                Log.e("TAG", "doInBackground: "+fileName );
                String FILE_EXTENSION = ".pdf";
                DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");

                //Adding Timestamp for multiple files to be stored in cache memory
                String fileNameTimeStamp = fileName + df.format(new Date()) + "." + FILE_EXTENSION;

                folder = Environment.getDownloadCacheDirectory() + File.separator + "file/";
                File directory = new File(context.getExternalCacheDir(), fileName);

                if (!directory.exists()) {
                    directory.getParentFile().mkdir();

                }
                OutputStream output = new FileOutputStream(directory);
                byte[] data = new byte[1024];
                long total = 0;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    publishProgress("" + (int) ((total * 100) / lengthOfFile));
                    output.write(data, 0, count);
                }
                output.flush();
                output.close();
                input.close();
                return fileName;
            } catch (Exception e) {
                Log.e("error",e.toString());
            }
            return "Something went wrong";
        }
        protected void onProgressUpdate(String... progress) {
            progressDialog.setProgress(Integer.parseInt(progress[0]));
        }
        @Override
        protected void onPostExecute(String message) {
            this.progressDialog.dismiss();
            Toast.makeText(context, "Download Complete View File.", Toast.LENGTH_SHORT).show();
        }
    }

    public String downloadReturn(String a,File b)
    {
        File[] files=context.getExternalCacheDir().listFiles();
        if(files!=null){
            for(File downloadedFile : files){

                if(downloadedFile.isDirectory()){
                    downloadReturn(a,downloadedFile);
                }
                else if(a.equalsIgnoreCase(downloadedFile.getName())){
                    return downloadedFile.getAbsolutePath();
                }
            }
        }
        return null;
    }

}
