DESCRIPTION = "Ubuntu Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel

# Override SRC_URI in a bbappend file to point at a different source
# tree if you do not want to build from Linus' tree.
SRC_URI = "git://kernel.ubuntu.com/ubuntu/linux.git;protocol=git \
           file://linux-vgt.patch \
           file://defconfig \
           "

LINUX_VERSION ?= "3.8"
LINUX_VERSION_EXTENSION ?= "-vgt"

SRCREV="d1baa1360260b5a01938674fc518109a4e5a148d"

S = "${WORKDIR}/git"

PR = "r1"
PV = "${LINUX_VERSION}+git${SRCPV}"

# Override COMPATIBLE_MACHINE to include your machine in a bbappend
# file. Leaving it empty here ensures an early explicit build failure.
COMPATIBLE_MACHINE_sugarbay = "sugarbay"
