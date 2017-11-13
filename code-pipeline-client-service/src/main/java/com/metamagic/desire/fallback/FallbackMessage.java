/**
 * Constants for Hystrix fallback messages 
 */
package com.metamagic.desire.fallback;

/**
 * @author Mahesh Pardeshi
 *
 */
public interface FallbackMessage {

	public static final String message = "Unable to communicate to requested service, please try after some time";

	public static final String messageId = "task.fallback";

	public static final String logoutMessageId = "auth.logout.fallback";

	public static final String loginMessageId = "auth.loginid.fallback";

	public static final String authenticateMessageId = "auth.authenticate.fallback";
}
