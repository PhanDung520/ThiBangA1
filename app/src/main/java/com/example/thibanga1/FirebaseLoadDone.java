package com.example.thibanga1;
import java.util.List;

import com.example.thibanga1.utils.QuestionData;

public interface FirebaseLoadDone {
    void onFirebaseLoadSuccess(List<QuestionData> questionDataList);
    void onFirebaseLoadFailed(String mess);
}
