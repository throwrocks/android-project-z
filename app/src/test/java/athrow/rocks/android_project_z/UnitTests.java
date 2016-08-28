package athrow.rocks.android_project_z;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import athrow.rocks.android_project_z.data.API;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class UnitTests extends Robolectric {
    String mBuildAPIKey = BuildConfig.UDACITY_REVIEWER_API_KEY;

    @Test
    public void testAPIGetCertifications() throws Exception{
        String result = API.callCertificationsAPI(mBuildAPIKey);
        assertTrue(result != null);
    }

}