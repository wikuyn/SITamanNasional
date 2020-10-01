package com.example.tamannasional;

import android.content.Context;

<<<<<<< HEAD
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;
=======
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
>>>>>>> a25244f... Sistem Informasi taman nasional jawa

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
<<<<<<< HEAD
        Context appContext = InstrumentationRegistry.getTargetContext();
=======
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
>>>>>>> a25244f... SistemInformasi taman nasional jawa

        assertEquals("com.example.tamannasional", appContext.getPackageName());
    }
}
