package yoga.android.vipin.com.vihangamyog.products;

import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import yoga.android.vipin.com.vihangamyog.R;

public class Bookreaderrr extends Fragment {
   // PDFView pdfView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vv = inflater.inflate(R.layout.activity_bookreaderrr, null, false);
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        //pdfView =vv.findViewById(R.id.pdfView);
        //storageReference= FirebaseStorage.getInstance().getReference();
        //pdfView.fromAsset("rr.pdf").load();
        // StorageReference islandRef = storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/b/bucket/o/images%20stars.jpg");
        StorageReference islandRef = storageRef.child("books/bb.pdf");

        final long ONE_MEGABYTE = 1024 * 1024;
        islandRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
             /*   pdfView.fromBytes(bytes).pages(0, 1, 2, 3, 4, 5, 6) // all pages are displayed by default
                        .enableSwipe(true) // allows to block changing pages using swipe
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .defaultPage(0).load();*/
                Toast.makeText(getActivity(), "the data is downloaded", Toast.LENGTH_LONG).show();
                // Data for "images/island.jpg" is returns, use this as needed
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(getActivity(), "the data is not downloaded" + exception, Toast.LENGTH_LONG).show();
                System.out.println("ddddd" + exception);
                // Handle any errors
            }
        });


        return vv;
    }
}

