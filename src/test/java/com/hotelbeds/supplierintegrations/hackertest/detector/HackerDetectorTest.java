package com.hotelbeds.supplierintegrations.hackertest.detector;

import com.hotelbeds.supplierintegrations.hackertest.detector.hackerDetector.HackerDetector;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HackerDetectorTest {

    @Autowired
    HackerDetector hackerDetector;

    @Test
    public void onlySuccessActionSameUsernameSameIp() {
        Assert.assertNull(hackerDetector.parseLine("80.238.9.179,133612947,SIGNIN_SUCCESS,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.9.179,133612948,SIGNIN_SUCCESS,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.9.179,133612949,SIGNIN_SUCCESS,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.9.179,133612950,SIGNIN_SUCCESS,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.9.179,133612951,SIGNIN_SUCCESS,Will.Smith"));
    }

    @Test
    public void onlySuccessActionMixedUsernameSameIp() {
        Assert.assertNull(hackerDetector.parseLine("80.238.10.179,133612947,SIGNIN_SUCCESS,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.10.179,133612948,SIGNIN_SUCCESS,Will.Smith2"));
        Assert.assertNull(hackerDetector.parseLine("80.238.10.179,133612949,SIGNIN_SUCCESS,Will.Smith3"));
        Assert.assertNull(hackerDetector.parseLine("80.238.10.179,133612950,SIGNIN_SUCCESS,Will.Smith4"));
        Assert.assertNull(hackerDetector.parseLine("80.238.10.179,133612951,SIGNIN_SUCCESS,Will.Smith5"));
    }

    @Test
    public void onlySuccessActionMixedUsernameMixedIp() {
        Assert.assertNull(hackerDetector.parseLine("80.238.11.179,133612947,SIGNIN_SUCCESS,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.11.180,133612948,SIGNIN_SUCCESS,Will.Smith2"));
        Assert.assertNull(hackerDetector.parseLine("80.238.11.181,133612949,SIGNIN_SUCCESS,Will.Smith3"));
        Assert.assertNull(hackerDetector.parseLine("80.238.11.182,133612950,SIGNIN_SUCCESS,Will.Smith4"));
        Assert.assertNull(hackerDetector.parseLine("80.238.11.183,133612951,SIGNIN_SUCCESS,Will.Smith5"));
    }

    @Test
    public void onlyFailureActionSameUsernameSameIp() {
        Assert.assertNull(hackerDetector.parseLine("80.238.12.179,133612947,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.12.179,133612948,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.12.179,133612949,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.12.179,133612950,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertEquals(hackerDetector.parseLine("80.238.12.179,133612951,SIGNIN_FAILURE,Will.Smith"), "80.238.12.179");
    }

    @Test
    public void onlyFailureActionSameUsernameMixedIp() {
        Assert.assertNull(hackerDetector.parseLine("80.238.13.179,133612947,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.13.180,133612948,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.13.181,133612949,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.13.182,133612950,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.13.183,133612951,SIGNIN_FAILURE,Will.Smith"));
    }

    @Test
    public void onlyFailureActionMixedUsernameSameIp() {
        Assert.assertNull(hackerDetector.parseLine("80.238.14.179,133612947,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.14.179,133612948,SIGNIN_FAILURE,Will.Smith2"));
        Assert.assertNull(hackerDetector.parseLine("80.238.14.179,133612949,SIGNIN_FAILURE,Will.Smith3"));
        Assert.assertNull(hackerDetector.parseLine("80.238.14.179,133612950,SIGNIN_FAILURE,Will.Smith4"));
        Assert.assertEquals(hackerDetector.parseLine("80.238.14.179,133612951,SIGNIN_FAILURE,Will.Smith5"), "80.238.14.179");
    }

    @Test
    public void onlyFailureActionMixedUsernameMixedIp() {
        Assert.assertNull(hackerDetector.parseLine("80.238.15.179,133612947,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.15.180,133612948,SIGNIN_FAILURE,Will.Smith2"));
        Assert.assertNull(hackerDetector.parseLine("80.238.15.181,133612949,SIGNIN_FAILURE,Will.Smith3"));
        Assert.assertNull(hackerDetector.parseLine("80.238.15.182,133612950,SIGNIN_FAILURE,Will.Smith4"));
        Assert.assertNull(hackerDetector.parseLine("80.238.15.183,133612951,SIGNIN_FAILURE,Will.Smith5"));
    }

    @Test
    public void onlyFailureActionSameUsernameSameIpMixedTimes() {

        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,133612947,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,133612948,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,133612949,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,133612950,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertEquals(hackerDetector.parseLine("80.238.19.179,133612951,SIGNIN_FAILURE,Will.Smith"), "80.238.19.179");
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,143612947,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,143612948,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,143612949,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,143612950,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertEquals(hackerDetector.parseLine("80.238.19.179,143612951,SIGNIN_FAILURE,Will.Smith"), "80.238.19.179");
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,153612947,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,153612948,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,153612949,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,153612950,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertEquals(hackerDetector.parseLine("80.238.19.179,153612951,SIGNIN_FAILURE,Will.Smith"), "80.238.19.179");
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,163612947,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,163612948,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,163612949,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,163612950,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertEquals(hackerDetector.parseLine("80.238.19.179,163612951,SIGNIN_FAILURE,Will.Smith"), "80.238.19.179");
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,173612947,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,173612948,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,183612947,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,183612948,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,183612949,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.19.179,183612950,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertEquals(hackerDetector.parseLine("80.238.19.179,183612951,SIGNIN_FAILURE,Will.Smith"), "80.238.19.179");
    }

    @Test
    public void mixedActionsSameUsername() {
        Assert.assertNull(hackerDetector.parseLine("80.238.16.179,133612947,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.16.179,133612948,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.16.179,133612949,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.16.179,133612950,SIGNIN_SUCCESS,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.16.179,133612951,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertEquals(hackerDetector.parseLine("80.238.16.179,133612952,SIGNIN_FAILURE,Will.Smith"), "80.238.16.179");
        Assert.assertEquals(hackerDetector.parseLine("80.238.16.179,133612953,SIGNIN_SUCCESS,Will.Smith"), "80.238.16.179");
        Assert.assertNull(hackerDetector.parseLine("80.238.16.179,143612947,SIGNIN_FAILURE,Will.Smith"));
    }

    @Test
    public void mixedActionsMixedUsernameSameIp() {
        Assert.assertNull(hackerDetector.parseLine("80.238.17.179,133612947,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.17.179,133612948,SIGNIN_FAILURE,Will.Smith2"));
        Assert.assertNull(hackerDetector.parseLine("80.238.17.179,133612949,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.17.179,133612950,SIGNIN_SUCCESS,Will.Smith3"));
        Assert.assertNull(hackerDetector.parseLine("80.238.17.179,133612951,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertEquals(hackerDetector.parseLine("80.238.17.179,133612952,SIGNIN_FAILURE,Will.Smith5"), "80.238.17.179");
        Assert.assertEquals(hackerDetector.parseLine("80.238.17.179,133612953,SIGNIN_SUCCESS,Will.Smith2"), "80.238.17.179");
        Assert.assertEquals(hackerDetector.parseLine("80.238.17.179,133612954,SIGNIN_FAILURE,Will.Smith3"), "80.238.17.179");
        Assert.assertEquals(hackerDetector.parseLine("80.238.17.179,133612955,SIGNIN_SUCCESS,Will.Smith"), "80.238.17.179");
        Assert.assertEquals(hackerDetector.parseLine("80.238.17.179,133612956,SIGNIN_FAILURE,Will.Smith2"), "80.238.17.179");
        Assert.assertEquals(hackerDetector.parseLine("80.238.17.179,133612957,SIGNIN_SUCCESS,Will.Smith"), "80.238.17.179");
        Assert.assertEquals(hackerDetector.parseLine("80.238.17.179,133612958,SIGNIN_FAILURE,Will.Smith4"), "80.238.17.179");
    }

    @Test
    public void mixedActionsMixedUsernameDifferentIp() {
        Assert.assertNull(hackerDetector.parseLine("80.238.18.179,133612947,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.18.180,133612948,SIGNIN_FAILURE,Will.Smith2"));
        Assert.assertNull(hackerDetector.parseLine("80.238.18.179,133612949,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.18.181,133612950,SIGNIN_SUCCESS,Will.Smith3"));
        Assert.assertNull(hackerDetector.parseLine("80.238.18.179,133612951,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.18.183,133612952,SIGNIN_FAILURE,Will.Smith5"));
        Assert.assertNull(hackerDetector.parseLine("80.238.18.180,133612953,SIGNIN_SUCCESS,Will.Smith2"));
        Assert.assertNull(hackerDetector.parseLine("80.238.18.181,133612954,SIGNIN_FAILURE,Will.Smith3"));
        Assert.assertNull(hackerDetector.parseLine("80.238.18.179,133612955,SIGNIN_SUCCESS,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.18.180,133612956,SIGNIN_FAILURE,Will.Smith2"));
        Assert.assertNull(hackerDetector.parseLine("80.238.18.179,133612957,SIGNIN_SUCCESS,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.18.182,133612958,SIGNIN_FAILURE,Will.Smith4"));
        Assert.assertNull(hackerDetector.parseLine("80.238.18.179,133612959,SIGNIN_SUCCESS,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.18.180,133612960,SIGNIN_FAILURE,Will.Smith2"));
        Assert.assertNull(hackerDetector.parseLine("80.238.18.181,133612961,SIGNIN_FAILURE,Will.Smith3"));
        Assert.assertNull(hackerDetector.parseLine("80.238.18.179,133612962,SIGNIN_FAILURE,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.18.180,133612963,SIGNIN_FAILURE,Will.Smith2"));
        Assert.assertNull(hackerDetector.parseLine("80.238.18.179,133612964,SIGNIN_SUCCESS,Will.Smith"));
        Assert.assertNull(hackerDetector.parseLine("80.238.18.182,133612965,SIGNIN_FAILURE,Will.Smith4"));
        Assert.assertEquals(hackerDetector.parseLine("80.238.18.179,133612966,SIGNIN_FAILURE,Will.Smith"), "80.238.18.179");
        Assert.assertEquals(hackerDetector.parseLine("80.238.18.180,133612963,SIGNIN_FAILURE,Will.Smith2"), "80.238.18.180");
    }
}
