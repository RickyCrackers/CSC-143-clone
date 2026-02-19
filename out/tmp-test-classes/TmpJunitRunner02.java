import java.io.PrintWriter;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.*;
import org.junit.platform.launcher.core.*;
import org.junit.platform.launcher.listeners.*;
public class TmpJunitRunner02 {
  public static void main(String[] args){
    LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
      .selectors(DiscoverySelectors.selectClass("junits.JUNIT02QQListTest"))
      .build();
    Launcher launcher = LauncherFactory.create();
    SummaryGeneratingListener listener = new SummaryGeneratingListener();
    launcher.registerTestExecutionListeners(listener);
    launcher.execute(request);
    TestExecutionSummary s = listener.getSummary();
    s.printTo(new PrintWriter(System.out));
  }
}
