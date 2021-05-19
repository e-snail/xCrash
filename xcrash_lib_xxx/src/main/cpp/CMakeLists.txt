cmake_minimum_required(VERSION 3.4.1)

#######################################
# global
#######################################

add_compile_options(
        -std=c11
        -Weverything
        -Werror)

#######################################
# libxcrash_xxx.so
#######################################

file(GLOB XCRASH_SRC
        xcrash/*.c
        common/*.c
        dl/*.c)

add_library(xcrash_xxx SHARED
        ${XCRASH_SRC})

target_include_directories(xcrash_xxx PUBLIC
        xcrash
        xcrash_dumper
        common
        dl)

target_link_libraries(xcrash_xxx
        log
        dl)

if(USEASAN)

target_compile_options(xcrash_xxx PUBLIC
        -fsanitize=address
        -fno-omit-frame-pointer)

set_target_properties(xcrash_xxx PROPERTIES
        LINK_FLAGS " \
        -fsanitize=address")

else()

target_compile_options(xcrash_xxx PUBLIC
        -Oz
        -flto
        -ffunction-sections
        -fdata-sections)

set_target_properties(xcrash_xxx PROPERTIES
        LINK_FLAGS " \
        -O3 \
        -flto \
        -Wl,--exclude-libs,ALL \
        -Wl,--gc-sections \
        -Wl,--version-script=${CMAKE_CURRENT_SOURCE_DIR}/xcrash.exports")

endif()

