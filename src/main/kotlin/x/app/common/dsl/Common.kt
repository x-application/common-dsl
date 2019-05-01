package x.app.common.dsl

import org.axonframework.commandhandling.gateway.CommandGateway
import x.app.common.AbstractCommand
import x.app.common.AbstractResult

/**
 *   @Project: dsl
 *   @Package: x.app.common.dsl
 *   @Author:  Iamee
 *   @Date:    2019-05-02 2:14
 */
@Suppress("UNCHECKED_CAST")
infix fun <T : AbstractResult> AbstractCommand<T>.sendTo(commandGateway: CommandGateway): T = commandGateway.sendAndWait<AbstractResult>(this).run {
    this.exception?.run { throw this }
    this as T
}