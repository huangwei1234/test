package www.sw.com;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
public class Testing extends AbstractJavaSamplerClient {
    String num1="";
    String num2="";

    public SampleResult runTest(JavaSamplerContext arg0) {
        num1 = arg0.getParameter("num1");
        num2 = arg0.getParameter("num2");
        SampleResult sr = new SampleResult();
        sr.setSampleLabel("求两数和");
        sr.sampleStart();
        T target = new T();
        int a,b,c;
        a=Integer.parseInt(num1);
        b=Integer.parseInt(num2);
        c= target.sum(a,b);
        sr.setResponseData( num1 + "和" + num2 + "相加的结果是:" + c, "OK!");
        sr.setDataType(SampleResult.TEXT);
        sr.setSuccessful(true);
        sr.sampleEnd();
        return sr;
    }

    public Arguments getDefaultParameters() {
        Arguments params = new Arguments();
        params.addArgument("num1", " ");
        params.addArgument("num2", " ");
        return params;
    }

    public static void main(String args[])
    {
        Arguments params = new Arguments();
        params.addArgument("num1", "1");//设置参数，并赋予默认值1
        params.addArgument("num2", "2");//设置参数，并赋予默认值2
        JavaSamplerContext arg0 = new JavaSamplerContext(params);
        Testing test = new Testing();
        test.setupTest(arg0);
        test.runTest(arg0);
        test.teardownTest(arg0);
    }

}