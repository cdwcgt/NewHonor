package com.github.euonmyoji.newhonor.sponge.command.args;

import com.github.euonmyoji.newhonor.sponge.NewHonor;
import com.github.euonmyoji.newhonor.sponge.api.configuration.PlayerConfig;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.entity.living.player.User;

import static org.spongepowered.api.text.Text.of;

/**
 * @author yinyangshi
 */
public final class SettingsArg {

    public static CommandSpec usehonor = CommandSpec.builder()
            .arguments(GenericArguments.bool(of("boolean")))
            .executor((src, args) -> {
                if (src instanceof User) {
                    try {
                        boolean use = args.<Boolean>getOne(of("boolean")).orElseThrow(NoSuchFieldError::new);
                        PlayerConfig pd = PlayerConfig.get(((User) src));
                        pd.setWhetherUseHonor(use);
                        NewHonor.updateCache(pd);
                        src.sendMessage(of("[NewHonor]change settings successful"));
                        return CommandResult.success();
                    } catch (Exception e) {
                        src.sendMessage(of("[NewHonor]error!"));
                        NewHonor.logger.warn("Change user " + src.getName() + "  settings but an error found", e);
                    }
                }
                src.sendMessage(of("[NewHonor]You are not a user"));
                return CommandResult.empty();
            })
            .build();

    public static CommandSpec enableEffects = CommandSpec.builder()
            .arguments(GenericArguments.bool(of("boolean")))
            .executor((src, args) -> {
                if (src instanceof User) {
                    try {
                        boolean enable = args.<Boolean>getOne(of("boolean")).orElseThrow(NoSuchFieldError::new);
                        PlayerConfig pd = PlayerConfig.get(((User) src));
                        pd.setWhetherEnableEffects(enable);
                        NewHonor.updateCache(pd);
                        src.sendMessage(of("[NewHonor]change settings successful"));
                        return CommandResult.success();
                    } catch (Exception e) {
                        src.sendMessage(of("[NewHonor]error!"));
                        NewHonor.logger.warn("Change user " + src.getName() + "  settings but an error found", e);
                        return CommandResult.empty();
                    }
                }
                src.sendMessage(of("[NewHonor]You are not a user"));
                return CommandResult.empty();
            })
            .build();

    public static CommandSpec autochange = CommandSpec.builder()
            .arguments(GenericArguments.bool(of("boolean")))
            .executor((src, args) -> {
                if (src instanceof User) {
                    try {
                        boolean enable = args.<Boolean>getOne(of("boolean")).orElseThrow(NoSuchFieldError::new);
                        PlayerConfig pd = PlayerConfig.get(((User) src));
                        pd.enableAutoChange(enable);
                        NewHonor.updateCache(pd);
                        src.sendMessage(of("[NewHonor]change settings successful"));
                        return CommandResult.success();
                    } catch (Exception e) {
                        src.sendMessage(of("[NewHonor]error!"));
                        NewHonor.logger.warn("Change user " + src.getName() + "  settings but an error found", e);
                        return CommandResult.empty();
                    }
                }
                src.sendMessage(of("[NewHonor]You are not a user"));
                return CommandResult.empty();
            })
            .build();

    private SettingsArg() {
        throw new UnsupportedOperationException();
    }
}