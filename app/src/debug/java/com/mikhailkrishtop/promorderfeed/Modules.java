package com.mikhailkrishtop.promorderfeed;

final class Modules {
    static Object[] list() {
        return new Object[] {
                new AppModule()
        };
    }

    private Modules() {
        // No instances.
    }
}
