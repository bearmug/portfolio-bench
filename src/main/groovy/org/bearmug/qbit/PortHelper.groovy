package org.bearmug.qbit

import groovy.util.logging.Slf4j
import io.advantageous.qbit.util.ConcurrentHashSet

@Slf4j
class PortHelper {

    static final MAX_RETRY = 10

    static final Set<Integer> BUSY_PORTS = new ConcurrentHashSet<>()

    static synchronized int getAvailablePort() {

        int result = -1

        MAX_RETRY.times {
            def tempServer = null

            try {
                tempServer = new ServerSocket(0)
                int res = tempServer.getLocalPort()
                if (!BUSY_PORTS.contains(res)) {
                    result = res
                    return false
                }
            } finally {
                tempServer.close()
            }
        }

        return result
    }

    static boolean releasePort(int port) {
        BUSY_PORTS.remove port
    }
}
