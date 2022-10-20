package com.stl.aopplugin.asm

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.Opcodes

class AOPClassVisitor(classVisitor: ClassVisitor?) : ClassVisitor(Opcodes.ASM7, classVisitor) {
}