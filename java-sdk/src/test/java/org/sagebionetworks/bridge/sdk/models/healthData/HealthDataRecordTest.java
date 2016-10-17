package org.sagebionetworks.bridge.sdk.models.healthData;

import org.junit.Test;
import org.sagebionetworks.bridge.Tests;
import org.sagebionetworks.bridge.sdk.Config;
import org.sagebionetworks.bridge.sdk.utils.Utilities;

import static org.junit.Assert.assertEquals;

public class HealthDataRecordTest {
    @Test
    public void canDeserialize() throws Exception {
        String json = Tests.unescapeJson("{'id':'test record id',"+"'uploadId':'test upload id',"+
                "'synapseExporterStatus':'SUCCEEDED'}");

        HealthDataRecord deser = Utilities.getMapper().readValue(json, HealthDataRecord.class);
        assertEquals(RecordExportStatusRequest.ExporterStatus.SUCCEEDED, deser.getSynapseExporterStatus());
        assertEquals("test record id", deser.getId());
        assertEquals("test upload id", deser.getUploadId());
    }
}