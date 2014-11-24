/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.doubango.tinyWRAP;

public enum tmedia_chroma_t {
  tmedia_chroma_none(0),
  tmedia_chroma_rgb24,
  tmedia_chroma_bgr24,
  tmedia_chroma_rgb32,
  tmedia_chroma_rgb565le,
  tmedia_chroma_rgb565be,
  tmedia_chroma_nv12,
  tmedia_chroma_nv21,
  tmedia_chroma_yuv422p,
  tmedia_chroma_uyvy422,
  tmedia_chroma_yuv420p,
  tmedia_chroma_mjpeg,
  tmedia_chroma_yuyv422;

  public final int swigValue() {
    return swigValue;
  }

  public static tmedia_chroma_t swigToEnum(int swigValue) {
    tmedia_chroma_t[] swigValues = tmedia_chroma_t.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (tmedia_chroma_t swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + tmedia_chroma_t.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private tmedia_chroma_t() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private tmedia_chroma_t(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private tmedia_chroma_t(tmedia_chroma_t swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}

