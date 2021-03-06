/*
 * Copyright (c) 2002-2008 LWJGL Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'LWJGL' nor the names of
 *   its contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package dwarf.lwjgl;

import static org.lwjgl.opengl.GL11.glBindTexture;

/**
 * A texture to be bound within OpenGL. This object is responsible for keeping
 * track of a given OpenGL texture and for calculating the texturing mapping
 * coordinates of the full image.
 *
 * Since textures need to be powers of 2 the actual texture may be considerably
 * bigged that the source image and hence the texture mapping coordinates need
 * to be adjusted to matchup drawing the sprite against the texture.
 *
 * @author Kevin Glass
 * @author Brian Matzon
 */
public class Texture extends java.lang.Object {

    /**
     * The GL target type
     */
    private int target;

    /**
     * The GL texture ID
     */
    private int textureID;

    /**
     * The height of the image
     */
    private int height;

    /**
     * The width of the image
     */
    private int width;

    /**
     * The width of the texture
     */
    private int texWidth;

    /**
     * The height of the texture
     */
    private int texHeight;

    /**
     * The ratio of the width of the image to the texture
     */
    private float widthRatio;

    /**
     * The ratio of the height of the image to the texture
     */
    private float heightRatio;

    /**
     * Default constructor.
     */
    public Texture() {
        super();
    }

    /**
     * Create a new texture
     *
     * @param target The GL target
     * @param textureID The GL texture ID
     */
    public Texture(int target, int textureID) {
        this.target = target;
        this.textureID = textureID;
    }

    /**
     * Bind the specified GL context to a texture
     */
    public void bind() {
        glBindTexture(target, textureID);
    }

    /**
     * Set the height of the image
     *
     * @param height The height of the image
     */
    public void setHeight(int height) {
        this.height = height;
        setHeight();
    }

    /**
     * Set the width of the image
     *
     * @param width The width of the image
     */
    public void setWidth(int width) {
        this.width = width;
        setWidth();
    }

    /**
     * Get the height of the original image
     *
     * @return The height of the original image
     */
    public int getImageHeight() {
        return height;
    }

    /**
     * Get the width of the original image
     *
     * @return The width of the original image
     */
    public int getImageWidth() {
        return width;
    }

    /**
     * Get the height of the physical texture
     *
     * @return The height of physical texture
     */
    public float getHeight() {
        return heightRatio;
    }

    /**
     * Get the width of the physical texture
     *
     * @return The width of physical texture
     */
    public float getWidth() {
        return widthRatio;
    }

    /**
     * Set the height of this texture
     *
     * @param texHeight The height of the texture
     */
    public void setTextureHeight(int texHeight) {
        this.texHeight = texHeight;
        setHeight();
    }

    /**
     * Set the width of this texture
     *
     * @param texWidth The width of the texture
     */
    public void setTextureWidth(int texWidth) {
        this.texWidth = texWidth;
        setWidth();
    }

    /**
     * Set the height of the texture. This will update the ratio also.
     */
    private void setHeight() {
        if (texHeight != 0) {
            heightRatio = ((float) height) / texHeight;
        }
    }

    /**
     * Set the width of the texture. This will update the ratio also.
     */
    private void setWidth() {
        if (texWidth != 0) {
            widthRatio = ((float) width) / texWidth;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.target;
        hash = 13 * hash + this.textureID;
        hash = 13 * hash + this.height;
        hash = 13 * hash + this.width;
        hash = 13 * hash + this.texWidth;
        hash = 13 * hash + this.texHeight;
        hash = 13 * hash + Float.floatToIntBits(this.widthRatio);
        hash = 13 * hash + Float.floatToIntBits(this.heightRatio);
        return hash;
    }

    /**
     * Returns true if the <code>this</code> is equal to the argument and false
     * otherwise. Consequently, if both argument are null, true is returned,
     * false is returned. Otherwise, equality is determined by using the equals
     * method of the first argument.
     *
     * @param obj the <code>Object</code> to be tested
     * @see java.lang.Object#equals(java.lang.Object)
     *
     * @return true if the argument is equal to <code>this</code> other and
     * false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }

        final Texture other = (Texture) obj;

        if (this.target != other.target) {
            return false;
        } else if (this.textureID != other.textureID) {
            return false;
        } else if (this.height != other.height) {
            return false;
        } else if (this.width != other.width) {
            return false;
        } else if (this.texWidth != other.texWidth) {
            return false;
        } else if (this.texHeight != other.texHeight) {
            return false;
        } else if (Float.floatToIntBits(this.widthRatio) != Float.floatToIntBits(other.widthRatio)) {
            return false;
        } else if (Float.floatToIntBits(this.heightRatio) != Float.floatToIntBits(other.heightRatio)) {
            return false;
        }

        return true;
    }
/**
     * Returns a string representation of the object.
     * <p>
     * In general, the toString method returns a string that "textually
     * represents" this object. The result should be a concise but informative
     * representation that is easy for a person to read. It is recommended that
     * all subclasses override this method.</p>
     *
     * @return a textually representation of this object
     */
    @Override
    public String toString() {
        return "Texture[" + "target: " + target + ", textureID: " + textureID
                + ", height: " + height + ", width: " + width + ", texWidth:"
                + texWidth + ", texHeight: " + texHeight + ", widthRatio: "
                + widthRatio + ", heightRatio: " + heightRatio + "]";
    }

}
