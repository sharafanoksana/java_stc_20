/**
 * @author Sharafan Oksana
 * @date 14.12.2019
 * @package lesson15
 */
package test;

import lesson15.dataBaseTables.UserRolesDaoJdbcImpl;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestResultLoggerExtension implements TestWatcher, AfterAllCallback {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRolesDaoJdbcImpl.class);
    private List<TestResultStatus> testResultStatuses = new ArrayList<>();

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        Map<TestResultStatus,Long> summary = testResultStatuses.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        LOGGER.info("Test Disabled for test {}: with reason :- {}",
                context.getDisplayName(),
                reason.orElse("No reason"));
        testResultStatuses.add(TestResultStatus.DISABLED);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        LOGGER.info("Test Successful for test {}: ", context.getDisplayName());
        testResultStatuses.add(TestResultStatus.SUCCESSFUL);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        LOGGER.info("Test Aborted for test {}: ", context.getDisplayName());
        testResultStatuses.add(TestResultStatus.ABORTED);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        LOGGER.info("Test Aborted for test {}: ", context.getDisplayName());
        testResultStatuses.add(TestResultStatus.FAILED);
    }

    private enum TestResultStatus {
        SUCCESSFUL, ABORTED, FAILED, DISABLED;
    }
}
