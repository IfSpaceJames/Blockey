package org.ifspace.blockey.feature;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.blockly.android.AbstractBlocklyActivity;
import com.google.blockly.android.codegen.CodeGenerationRequest;
import com.google.blockly.android.codegen.LoggingCodeGeneratorCallback;
import com.google.blockly.model.DefaultBlocks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//public class MainActivity extends AbstractBlocklyActivity {
public class MainActivity extends Activity {
    int DEFAULT_PORT = 8080;
//    private static final List<String> JAVASCRIPT_GENERATORS = Arrays.asList(
//            // Custom block generators go here. Default blocks are already included.
//    );

//    CodeGenerationRequest.CodeGeneratorCallback mCodeGeneratorCallback =
//            new LoggingCodeGeneratorCallback(this, "LoggingTag");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidWebServer androidWebServer = new AndroidWebServer(DEFAULT_PORT);
        try {
            androidWebServer.setScratchProgId("11397100");
            androidWebServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //androidWebServer.stop();
        setContentView(R.layout.activity_main);
    }

//    @NonNull
//    @Override
//    protected String getToolboxContentsXmlPath() {
//        return "default/toolbox.xml";
//    }
//
//    @NonNull
//    @Override
//    protected List<String> getBlockDefinitionsJsonPaths() {
//        List<String> assetPaths = new ArrayList<>(DefaultBlocks.getAllBlockDefinitions());
//        // Append your own block definitions here.
//        return assetPaths;
//    }
//
//    @NonNull
//    @Override
//    protected List<String> getGeneratorsJsPaths() {
//        return JAVASCRIPT_GENERATORS;
//    }
//
//    @NonNull
//    @Override
//    protected CodeGenerationRequest.CodeGeneratorCallback getCodeGenerationCallback() {
//        return mCodeGeneratorCallback;
//    }
//
//    @Override
//    protected void onInitBlankWorkspace() {
//        // Initialize available variable names.
//        getController().addVariable("item");
//    }
}
