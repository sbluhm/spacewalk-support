testOptions in Test +=
	Tests.Setup { () =>
		IO.touch(baseDirectory.value / "setup")
	}

testOptions in Test += {
	val t = baseDirectory.value / "tested"
	val c = baseDirectory.value / "cleanup"
	Tests.Cleanup { () =>
		assert(t.exists, "Didn't exist: " + t.getAbsolutePath)
		IO.delete(t)
		IO.touch(c)
	}
}