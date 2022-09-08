package org.springotmc.framework.plan.task;

import org.springotmc.framework.SpringotFramework;
import org.springotmc.framework.plan.ExecutionTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class PlatformBannerStartupTask implements ExecutionTask<SpringotFramework> {

    @Override
    public void execute(SpringotFramework platform) {

        InputStream bannerResource = Thread.currentThread().getContextClassLoader().getResourceAsStream("banner.txt");
        if (bannerResource == null) {
            platform.log("Springot Framework Initialized");
            return;
        }

        platform.log(new BufferedReader(new InputStreamReader(bannerResource))
            .lines()
            .collect(Collectors.joining("\n")));
    }
}
