package org.grails.plugins.zkui

class ZulTagLib extends AbstractTagLib {

    static namespace = "z"

    /**
     *
     * @attr dir
     * @attr href
     * @attr target
     * @attr tabindex
     * @attr disabled
     * @attr image
     * @attr imageContent
     * @attr hoverImage
     * @attr hoverImageContent
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def a = { attrs, body ->
        doTag(attrs, body, "a")
    }

    /**
     *
     * @attr x
     * @attr y
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def absolutechildren = { attrs, body ->
        doTag(attrs, body, "absolutechildren")
    }

    /**
     *
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def absolutelayout = { attrs, body ->
        doTag(attrs, body, "absolutelayout")
    }

    /**
     *
     * @attr anchor
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def anchorchildren = { attrs, body ->
        doTag(attrs, body, "anchorchildren")
    }

    /**
     *
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def anchorlayout = { attrs, body ->
        doTag(attrs, body, "anchorlayout")
    }

    /**
     *
     * @attr code
     * @attr codebase
     * @attr archive
     * @attr align
     * @attr hspace
     * @attr vspace
     * @attr mayscript
     * @attr params
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def applet = { attrs, body ->
        doTag(attrs, body, "applet")
    }

    /**
     *
     * @attr shape
     * @attr coords
     * @attr tooltiptext
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def area = { attrs, body ->
        doTag(attrs, body, "area")
    }

    /**
     *
     * @attr align
     * @attr border
     * @attr src
     * @attr autostart
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def audio = { attrs, body ->
        doTag(attrs, body, "audio")
    }

    /**
     *
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def auxhead = { attrs, body ->
        doTag(attrs, body, "auxhead")
    }

    /**
     *
     * @attr colspan
     * @attr rowspan
     * @attr align
     * @attr valign
     * @attr image
     * @attr imageContent
     * @attr hoverImage
     * @attr hoverImageContent
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     */
    def auxheader = { attrs, body ->
        doTag(attrs, body, "auxheader")
    }

    /**
     *
     * @attr autodrop
     * @attr buttonVisible
     * @attr constraint
     * @attr value
     * @attr type
     * @attr open
     * @attr onOpen
     * @attr name
     * @attr disabled
     * @attr readonly
     * @attr placeholder
     * @attr inplace
     * @attr instant
     * @attr maxlength
     * @attr cols
     * @attr tabindex
     * @attr onChange
     * @attr onChanging
     * @attr onFocus
     * @attr onBlur
     * @attr onOK
     * @attr onCancel
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def bandbox = { attrs, body ->
        doTag(attrs, body, "bandbox")
    }

    /**
     *
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def bandpopup = { attrs, body ->
        doTag(attrs, body, "bandpopup")
    }

    /**
     *
     * @attr rows
     * @attr cols
     * @attr frozenCols
     * @attr rowHeight
     * @attr colWidth
     * @attr maxtrixRenderer
     * @attr model
     * @attr sortAscending
     * @attr sortDescending
     * @attr oddRowSclass
     * @attr onSelect
     * @attr onScroll
     * @attr onScrollX
     * @attr onScrollY
     * @attr onCellClick
     * @attr onAfterRender
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def biglistbox = { attrs, body ->
        doTag(attrs, body, "biglistbox")
    }

    /**
     *
     * @attr animationDisabled
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def borderlayout = { attrs, body ->
        doTag(attrs, body, "borderlayout")
    }

    /**
     *
     * @attr orient
     * @attr spacing
     * @attr widths
     * @attr heights
     * @attr align
     * @attr pack
     * @attr sizedByContent
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def box = { attrs, body ->
        doTag(attrs, body, "box")
    }

    /**
     *
     * @attr orient
     * @attr dir
     * @attr type
     * @attr href
     * @attr target
     * @attr disabled
     * @attr autodisable
     * @attr tabindex
     * @attr upload
     * @attr image
     * @attr imageContent
     * @attr hoverImage
     * @attr hoverImageContent
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def button = { attrs, body ->
        doTag(attrs, body, "button")
    }

    /**
     *
     * @attr name
     * @attr value
     * @attr weekOfYear
     * @attr onChange
     * @attr onWeekClick
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def calendar = { attrs, body ->
        doTag(attrs, body, "calendar")
    }

    /**
     *
     * @attr days
     * @attr beginTime
     * @attr endTime
     * @attr timeslots
     * @attr model
     * @attr firstDayOfWeek
     * @attr weekOfYear
     * @attr dateFormatter
     * @attr readonly
     * @attr timeZone
     * @attr onEventCreate
     * @attr onEventEdit
     * @attr onEventUpdate
     * @attr onDayClick
     * @attr onWeekClick
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def calendars = { attrs, body ->
        doTag(attrs, body, "calendars")
    }

    /**
     *
     * @attr image
     * @attr imageContent
     * @attr hoverImage
     * @attr hoverImageContent
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     */
    def caption = { attrs, body ->
        doTag(attrs, body, "caption")
    }

    /**
     *
     * @attr selectedIndex
     * @attr orient
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def cardlayout = { attrs, body ->
        doTag(attrs, body, "cardlayout")
    }

    /**
     *
     * @attr colspan
     * @attr rowspan
     * @attr align
     * @attr valign
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def cell = { attrs, body ->
        doTag(attrs, body, "cell")
    }

    /**
     *
     * @attr flex
     * @attr margins
     * @attr autoscroll
     * @attr border
     * @attr onOpen
     * @attr title
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def center = { attrs, body ->
        doTag(attrs, body, "center")
    }

    /**
     *
     * @attr type
     * @attr model
     * @attr title
     * @attr xAxis
     * @attr yAxis
     * @attr threeD
     * @attr showLegend
     * @attr showTooltiptext
     * @attr paneAlpha
     * @attr paneColor
     * @attr fgAlpha
     * @attr bgAlpha
     * @attr bgColor
     * @attr orient
     * @attr timeZone
     * @attr period
     * @attr areaListener
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onClick
     * @attr onRightClick
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def chart = { attrs, body ->
        doTag(attrs, body, "chart")
    }

    /**
     *
     * @attr name
     * @attr checked
     * @attr disabled
     * @attr tabindex
     * @attr onCheck
     * @attr value
     * @attr image
     * @attr imageContent
     * @attr hoverImage
     * @attr hoverImageContent
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def checkbox = { attrs, body ->
        doTag(attrs, body, "checkbox")
    }

    /**
     *
     * @attr creatable
     * @attr createMessage
     * @attr disabled
     * @attr emptyMessage
     * @attr model
     * @attr name
     * @attr noResultsText
     * @attr open
     * @attr tabindex
     * @attr separator
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def chosenbox = { attrs, body ->
        doTag(attrs, body, "chosenbox")
    }

    /**
     *
     * @attr color
     * @attr value
     * @attr disabled
     * @attr onChange
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def colorbox = { attrs, body ->
        doTag(attrs, body, "colorbox")
    }

    /**
     *
     * @attr sort
     * @attr sortDirection
     * @attr sortAscending
     * @attr sortDescending
     * @attr onSort
     * @attr onGroup
     * @attr onUngroup
     * @attr value
     * @attr align
     * @attr valign
     * @attr image
     * @attr imageContent
     * @attr hoverImage
     * @attr hoverImageContent
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     */
    def column = { attrs, body ->
        doTag(attrs, body, "column")
    }

    /**
     *
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def columnchildren = { attrs, body ->
        doTag(attrs, body, "columnchildren")
    }

    /**
     *
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def columnlayout = { attrs, body ->
        doTag(attrs, body, "columnlayout")
    }

    /**
     *
     * @attr sizable
     * @attr value
     * @attr menupopup
     * @attr columnshide
     * @attr columnsgroup
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def columns = { attrs, body ->
        doTag(attrs, body, "columns")
    }

    /**
     *
     * @attr autocomplete
     * @attr autodrop
     * @attr buttonVisible
     * @attr constraint
     * @attr value
     * @attr model
     * @attr itemRenderer
     * @attr type
     * @attr open
     * @attr selectedItem
     * @attr selectedIndex
     * @attr onOpen
     * @attr onSelect
     * @attr name
     * @attr disabled
     * @attr readonly
     * @attr placeholder
     * @attr inplace
     * @attr instant
     * @attr maxlength
     * @attr cols
     * @attr tabindex
     * @attr onChange
     * @attr onChanging
     * @attr onFocus
     * @attr onBlur
     * @attr onOK
     * @attr onCancel
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def combobox = { attrs, body ->
        doTag(attrs, body, "combobox")
    }

    /**
     *
     * @attr description
     * @attr value
     * @attr content
     * @attr disabled
     * @attr image
     * @attr imageContent
     * @attr hoverImage
     * @attr hoverImageContent
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     */
    def comboitem = { attrs, body ->
        doTag(attrs, body, "comboitem")
    }

    /**
     *
     * @attr orient
     * @attr dir
     * @attr type
     * @attr href
     * @attr target
     * @attr disabled
     * @attr autodisable
     * @attr tabindex
     * @attr image
     * @attr imageContent
     * @attr hoverImage
     * @attr hoverImageContent
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def combobutton = { attrs, body ->
        doTag(attrs, body, "combobutton")
    }

    /**
     *
     * @attr constraint
     * @attr value
     * @attr lenient
     * @attr buttonVisible
     * @attr open
     * @attr displayedTimeZones
     * @attr timeZonesReadonly
     * @attr locale
     * @attr weekOfYear
     * @attr format
     * @attr name
     * @attr disabled
     * @attr readonly
     * @attr placeholder
     * @attr inplace
     * @attr instant
     * @attr maxlength
     * @attr cols
     * @attr tabindex
     * @attr onChange
     * @attr onChanging
     * @attr onFocus
     * @attr onBlur
     * @attr onOK
     * @attr onCancel
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def datebox = { attrs, body ->
        doTag(attrs, body, "datebox")
    }

    /**
     *
     * @attr constraint
     * @attr value
     * @attr scale
     * @attr roundingMode
     * @attr locale
     * @attr format
     * @attr name
     * @attr disabled
     * @attr readonly
     * @attr placeholder
     * @attr inplace
     * @attr instant
     * @attr maxlength
     * @attr cols
     * @attr tabindex
     * @attr onChange
     * @attr onChanging
     * @attr onFocus
     * @attr onBlur
     * @attr onOK
     * @attr onCancel
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def decimalbox = { attrs, body ->
        doTag(attrs, body, "decimalbox")
    }

    /**
     *
     * @attr contentStyle
     * @attr image
     * @attr open
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def detail = { attrs, body ->
        doTag(attrs, body, "detail")
    }

    /**
     *
     * @attr align
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def div = { attrs, body ->
        doTag(attrs, body, "div")
    }

    /**
     *
     * @attr constraint
     * @attr value
     * @attr roundingMode
     * @attr locale
     * @attr format
     * @attr name
     * @attr disabled
     * @attr readonly
     * @attr placeholder
     * @attr inplace
     * @attr instant
     * @attr maxlength
     * @attr cols
     * @attr tabindex
     * @attr onChange
     * @attr onChanging
     * @attr onFocus
     * @attr onBlur
     * @attr onOK
     * @attr onCancel
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def doublebox = { attrs, body ->
        doTag(attrs, body, "doublebox")
    }

    /**
     *
     * @attr constraint
     * @attr buttonVisible
     * @attr step
     * @attr value
     * @attr roundingMode
     * @attr locale
     * @attr format
     * @attr name
     * @attr disabled
     * @attr readonly
     * @attr placeholder
     * @attr inplace
     * @attr instant
     * @attr maxlength
     * @attr cols
     * @attr tabindex
     * @attr onChange
     * @attr onChanging
     * @attr onFocus
     * @attr onBlur
     * @attr onOK
     * @attr onCancel
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def doublespinner = { attrs, body ->
        doTag(attrs, body, "doublespinner")
    }

    /**
     *
     * @attr content
     * @attr maxsize
     * @attr detection
     * @attr native
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def dropupload = { attrs, body ->
        doTag(attrs, body, "dropupload")
    }

    /**
     *
     * @attr flex
     * @attr size
     * @attr splittable
     * @attr collapsible
     * @attr margins
     * @attr open
     * @attr autoscroll
     * @attr border
     * @attr maxsize
     * @attr minsize
     * @attr onOpen
     * @attr title
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def east = { attrs, body ->
        doTag(attrs, body, "east")
    }

    /**
     *
     * @attr native
     * @attr number
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def fileupload = { attrs, body ->
        doTag(attrs, body, "fileupload")
    }

    /**
     *
     * @attr label
     * @attr image
     * @attr imageContent
     * @attr onClick
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def fisheye = { attrs, body ->
        doTag(attrs, body, "fisheye")
    }

    /**
     *
     * @attr itemWidth
     * @attr itemHeight
     * @attr itemMaxWidth
     * @attr itemMaxHeight
     * @attr itemPadding
     * @attr orient
     * @attr attachEdge
     * @attr labelEdge
     * @attr onChildAdded
     * @attr onChildRemoved
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def fisheyebar = { attrs, body ->
        doTag(attrs, body, "fisheyebar")
    }

    /**
     *
     * @attr bgcolor
     * @attr loop
     * @attr autoplay
     * @attr wmode
     * @attr src
     * @attr content
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def flashes = { attrs, body ->
        doTag(attrs, body, "flash")
    }

    /**
     *
     * @attr type
     * @attr model
     * @attr xAxis
     * @attr yAxis
     * @attr chartStyle
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def flashchart = { attrs, body ->
        doTag(attrs, body, "flashchart")
    }

    /**
     *
     * @attr type
     * @attr model
     * @attr tableModel
     * @attr chartConfig
     * @attr tableRenderer
     * @attr engine
     * @attr dataXMLPath
     * @attr title
     * @attr subTitle
     * @attr xAxis
     * @attr yAxis
     * @attr threeD
     * @attr showLegend
     * @attr orient
     * @attr onClick
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def fusionchart = { attrs, body ->
        doTag(attrs, body, "fusionchart")
    }

    /**
     *
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def foot = { attrs, body ->
        doTag(attrs, body, "foot")
    }

    /**
     *
     * @attr align
     * @attr valign
     * @attr span
     * @attr image
     * @attr imageContent
     * @attr hoverImage
     * @attr hoverImageContent
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     */
    def footer = { attrs, body ->
        doTag(attrs, body, "footer")
    }

    /**
     *
     * @attr columns
     * @attr start
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def frozen = { attrs, body ->
        doTag(attrs, body, "frozen")
    }

    /**
     *
     * @attr pageSize
     * @attr paginal
     * @attr model
     * @attr rowRenderer
     * @attr sizedByContent
     * @attr oddRowSclass
     * @attr onPaging
     * @attr pagingPosition
     * @attr innerWidth
     * @attr autopaging
     * @attr emptyMessage
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def grid = { attrs, body ->
        doTag(attrs, body, "grid")
    }

    /**
     *
     * @attr open
     * @attr closable
     * @attr contentStyle
     * @attr onOpen
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def groupbox = { attrs, body ->
        doTag(attrs, body, "groupbox")
    }

    /**
     *
     * @attr align
     * @attr nowrap
     * @attr spans
     * @attr valign
     * @attr value
     * @attr label
     * @attr open
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def group = { attrs, body ->
        doTag(attrs, body, "group")
    }

    /**
     *
     * @attr align
     * @attr nowrap
     * @attr spans
     * @attr valign
     * @attr value
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def groupfoot = { attrs, body ->
        doTag(attrs, body, "groupfoot")
    }

    /**
     *
     * @attr spacing
     * @attr widths
     * @attr align
     * @attr pack
     * @attr sizedByContent
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def hbox = { attrs, body ->
        doTag(attrs, body, "hbox")
    }

    /**
     *
     * @attr valign
     * @attr spacing
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def hlayout = { attrs, body ->
        doTag(attrs, body, "hlayout")
    }

    /**
     *
     * @attr content
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def html = { attrs, body ->
        doTag(attrs, body, "html")
    }

    /**
     *
     * @attr name
     * @attr src
     * @attr scrolling
     * @attr autohide
     * @attr onURIChange
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def iframe = { attrs, body ->
        doTag(attrs, body, "iframe")
    }

    /**
     *
     * @attr src
     * @attr content
     * @attr hover
     * @attr hoverContent
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def image = { attrs, body ->
        doTag(attrs, body, "image")
    }

    /**
     *
     * @attr src
     * @attr content
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onClick
     * @attr onRightClick
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def imagemap = { attrs, body ->
        doTag(attrs, body, "imagemap")
    }

    /**
     *
     * @attr src
     * @attr localized
     * @attr progressing
     * @attr mode
     * @attr comment
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def include = { attrs, body ->
        doTag(attrs, body, "include")
    }

    /**
     *
     * @attr constraint
     * @attr value
     * @attr roundingMode
     * @attr locale
     * @attr format
     * @attr name
     * @attr disabled
     * @attr readonly
     * @attr placeholder
     * @attr inplace
     * @attr instant
     * @attr maxlength
     * @attr cols
     * @attr tabindex
     * @attr onChange
     * @attr onChanging
     * @attr onFocus
     * @attr onBlur
     * @attr onOK
     * @attr onCancel
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def intbox = { attrs, body ->
        doTag(attrs, body, "intbox")
    }

    /**
     *
     * @attr constraint
     * @attr value
     * @attr roundingMode
     * @attr locale
     * @attr format
     * @attr name
     * @attr disabled
     * @attr readonly
     * @attr placeholder
     * @attr inplace
     * @attr instant
     * @attr maxlength
     * @attr cols
     * @attr tabindex
     * @attr onChange
     * @attr onChanging
     * @attr onFocus
     * @attr onBlur
     * @attr onOK
     * @attr onCancel
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def longbox = { attrs, body ->
        doTag(attrs, body, "longbox")
    }

    /**
     *
     * @attr value
     * @attr multiline
     * @attr maxlength
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def label = { attrs, body ->
        doTag(attrs, body, "label")
    }

    /**
     *
     * @attr checkmark
     * @attr disabled
     * @attr pageSize
     * @attr paginal
     * @attr onPaging
     * @attr multiple
     * @attr rows
     * @attr maxlength
     * @attr name
     * @attr oddRowSclass
     * @attr selectedItem
     * @attr selectedIndex
     * @attr tabindex
     * @attr model
     * @attr itemRenderer
     * @attr sizedByContent
     * @attr onSelect
     * @attr pagingPosition
     * @attr innerWidth
     * @attr nonselectableTags
     * @attr autopaging
     * @attr emptyMessage
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def listbox = { attrs, body ->
        doTag(attrs, body, "listbox")
    }

    /**
     *
     * @attr span
     * @attr image
     * @attr imageContent
     * @attr hoverImage
     * @attr hoverImageContent
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     */
    def listcell = { attrs, body ->
        doTag(attrs, body, "listcell")
    }

    /**
     *
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def listfoot = { attrs, body ->
        doTag(attrs, body, "listfoot")
    }

    /**
     *
     * @attr align
     * @attr valign
     * @attr span
     * @attr image
     * @attr imageContent
     * @attr hoverImage
     * @attr hoverImageContent
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     */
    def listfooter = { attrs, body ->
        doTag(attrs, body, "listfooter")
    }

    /**
     *
     * @attr label
     * @attr value
     * @attr disabled
     * @attr checkable
     * @attr selected
     * @attr open
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def listgroup = { attrs, body ->
        doTag(attrs, body, "listgroup")
    }

    /**
     *
     * @attr label
     * @attr value
     * @attr disabled
     * @attr checkable
     * @attr selected
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def listgroupfoot = { attrs, body ->
        doTag(attrs, body, "listgroupfoot")
    }

    /**
     *
     * @attr menupopup
     * @attr columnshide
     * @attr columnsgroup
     * @attr sizable
     * @attr value
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def listhead = { attrs, body ->
        doTag(attrs, body, "listhead")
    }

    /**
     *
     * @attr sort
     * @attr sortDirection
     * @attr sortAscending
     * @attr sortDescending
     * @attr maxlength
     * @attr onSort
     * @attr onGroup
     * @attr onUngroup
     * @attr value
     * @attr align
     * @attr valign
     * @attr image
     * @attr imageContent
     * @attr hoverImage
     * @attr hoverImageContent
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     */
    def listheader = { attrs, body ->
        doTag(attrs, body, "listheader")
    }

    /**
     *
     * @attr label
     * @attr value
     * @attr disabled
     * @attr checkable
     * @attr selected
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def listitem = { attrs, body ->
        doTag(attrs, body, "listitem")
    }

    /**
     *
     * @attr content
     * @attr image
     * @attr imageContent
     * @attr hoverImage
     * @attr hoverImageContent
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     */
    def menu = { attrs, body ->
        doTag(attrs, body, "menu")
    }

    /**
     *
     * @attr orient
     * @attr autodrop
     * @attr scrollable
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def menubar = { attrs, body ->
        doTag(attrs, body, "menubar")
    }

    /**
     *
     * @attr checkmark
     * @attr value
     * @attr checked
     * @attr autocheck
     * @attr href
     * @attr target
     * @attr disabled
     * @attr src
     * @attr image
     * @attr imageContent
     * @attr hoverImage
     * @attr hoverImageContent
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     */
    def menuitem = { attrs, body ->
        doTag(attrs, body, "menuitem")
    }

    /**
     *
     * @attr onOpen
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def menupopup = { attrs, body ->
        doTag(attrs, body, "menupopup")
    }

    /**
     *
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def menuseparator = { attrs, body ->
        doTag(attrs, body, "menuseparator")
    }

    /**
     *
     * @attr flex
     * @attr size
     * @attr splittable
     * @attr collapsible
     * @attr margins
     * @attr open
     * @attr autoscroll
     * @attr border
     * @attr maxsize
     * @attr minsize
     * @attr onOpen
     * @attr title
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def north = { attrs, body ->
        doTag(attrs, body, "north")
    }

    /**
     *
     * @attr border
     * @attr closable
     * @attr collapsible
     * @attr floatable
     * @attr maximizable
     * @attr maximized
     * @attr minimized
     * @attr minimizable
     * @attr movable
     * @attr open
     * @attr title
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def panel = { attrs, body ->
        doTag(attrs, body, "panel")
    }

    /**
     *
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def panelchildren = { attrs, body ->
        doTag(attrs, body, "panelchildren")
    }

    /**
     *
     * @attr pageSize
     * @attr totalSize
     * @attr activePage
     * @attr pageIncrement
     * @attr detailed
     * @attr autohide
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def paging = { attrs, body ->
        doTag(attrs, body, "paging")
    }

    /**
     *
     * @attr pageSize
     * @attr activePage
     * @attr totalSize
     * @attr grandTotalForRows
     * @attr grandTotalForColumns
     * @attr dataFieldOrient
     * @attr model
     * @attr pivotRenderer
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def pivottable = { attrs, body ->
        doTag(attrs, body, "pivottable")
    }

    /**
     *
     * @attr onOpen
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def popup = { attrs, body ->
        doTag(attrs, body, "popup")
    }

    /**
     *
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def portalchildren = { attrs, body ->
        doTag(attrs, body, "portalchildren")
    }

    /**
     *
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def portallayout = { attrs, body ->
        doTag(attrs, body, "portallayout")
    }

    /**
     *
     * @attr value
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def progressmeter = { attrs, body ->
        doTag(attrs, body, "progressmeter")
    }

    /**
     *
     * @attr selected
     * @attr checked
     * @attr disabled
     * @attr tabindex
     * @attr value
     * @attr onCheck
     * @attr radiogroup
     * @attr image
     * @attr imageContent
     * @attr hoverImage
     * @attr hoverImageContent
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     */
    def radio = { attrs, body ->
        doTag(attrs, body, "radio")
    }

    /**
     *
     * @attr name
     * @attr orient
     * @attr selectedItem
     * @attr selectedIndex
     * @attr onCheck
     * @attr model
     * @attr radioRenderer
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def radiogroup = { attrs, body ->
        doTag(attrs, body, "radiogroup")
    }

    /**
     *
     * @attr align
     * @attr nowrap
     * @attr spans
     * @attr valign
     * @attr value
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def row = { attrs, body ->
        doTag(attrs, body, "row")
    }

    /**
     *
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def rows = { attrs, body ->
        doTag(attrs, body, "rows")
    }

    /**
     *
     * @attr src
     * @attr type
     * @attr charset
     * @attr defer
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def script = { attrs, body ->
        doTag(attrs, body, "script")
    }

    /**
     *
     * @attr orient
     * @attr onScrolling
     * @attr onScroll
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def scrollview = { attrs, body ->
        doTag(attrs, body, "scrollview")
    }

    /**
     *
     * @attr name
     * @attr disabled
     * @attr selectedIndex
     * @attr tabindex
     * @attr itemRenderer
     * @attr onSelect
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def selectbox = { attrs, body ->
        doTag(attrs, body, "selectbox")
    }

    /**
     *
     * @attr spacing
     * @attr orient
     * @attr bar
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def separator = { attrs, body ->
        doTag(attrs, body, "separator")
    }

    /**
     *
     * @attr name
     * @attr curpos
     * @attr maxpos
     * @attr slidingtext
     * @attr pageIncrement
     * @attr onRightClick
     * @attr onScroll
     * @attr onScrolling
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def slider = { attrs, body ->
        doTag(attrs, body, "slider")
    }

    /**
     *
     * @attr flex
     * @attr size
     * @attr splittable
     * @attr collapsible
     * @attr margins
     * @attr open
     * @attr autoscroll
     * @attr border
     * @attr maxsize
     * @attr minsize
     * @attr onOpen
     * @attr title
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def south = { attrs, body ->
        doTag(attrs, body, "south")
    }

    /**
     *
     * @attr spacing
     * @attr orient
     * @attr bar
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def space = { attrs, body ->
        doTag(attrs, body, "space")
    }

    /**
     *
     * @attr constraint
     * @attr buttonVisible
     * @attr step
     * @attr value
     * @attr roundingMode
     * @attr locale
     * @attr format
     * @attr name
     * @attr disabled
     * @attr readonly
     * @attr placeholder
     * @attr inplace
     * @attr instant
     * @attr maxlength
     * @attr cols
     * @attr tabindex
     * @attr onChange
     * @attr onChanging
     * @attr onFocus
     * @attr onBlur
     * @attr onOK
     * @attr onCancel
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def spinner = { attrs, body ->
        doTag(attrs, body, "spinner")
    }

    /**
     *
     * @attr collapse
     * @attr open
     * @attr onOpen
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def splitter = { attrs, body ->
        doTag(attrs, body, "splitter")
    }

    /**
     *
     * @attr src
     * @attr content
     * @attr media
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def style = { attrs, body ->
        doTag(attrs, body, "style")
    }

    /**
     *
     * @attr selected
     * @attr closable
     * @attr onClose
     * @attr image
     * @attr imageContent
     * @attr hoverImage
     * @attr hoverImageContent
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     */
    def tab = { attrs, body ->
        doTag(attrs, body, "tab")
    }

    /**
     *
     * @attr tabscroll
     * @attr panelSpacing
     * @attr selectedIndex
     * @attr selectedTab
     * @attr selectedPanel
     * @attr orient
     * @attr onRightClick
     * @attr onSelect
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def tabbox = { attrs, body ->
        doTag(attrs, body, "tabbox")
    }

    /**
     *
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     */
    def tabpanel = { attrs, body ->
        doTag(attrs, body, "tabpanel")
    }

    /**
     *
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def tabpanels = { attrs, body ->
        doTag(attrs, body, "tabpanels")
    }

    /**
     *
     * @attr align
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def tabs = { attrs, body ->
        doTag(attrs, body, "tabs")
    }

    /**
     *
     * @attr colspan
     * @attr rowspan
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def tablechildren = { attrs, body ->
        doTag(attrs, body, "tablechildren")
    }

    /**
     *
     * @attr columns
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def tablelayout = { attrs, body ->
        doTag(attrs, body, "tablelayout")
    }

    /**
     *
     * @attr constraint
     * @attr value
     * @attr type
     * @attr rows
     * @attr multiline
     * @attr tabbable
     * @attr name
     * @attr disabled
     * @attr readonly
     * @attr placeholder
     * @attr inplace
     * @attr instant
     * @attr maxlength
     * @attr cols
     * @attr tabindex
     * @attr onChange
     * @attr onChanging
     * @attr onFocus
     * @attr onBlur
     * @attr onOK
     * @attr onCancel
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def textbox = { attrs, body ->
        doTag(attrs, body, "textbox")
    }

    /**
     *
     * @attr delay
     * @attr repeats
     * @attr running
     * @attr onTimer
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def timer = { attrs, body ->
        doTag(attrs, body, "timer")
    }

    /**
     *
     * @attr constraint
     * @attr value
     * @attr buttonVisible
     * @attr timeZone
     * @attr locale
     * @attr format
     * @attr name
     * @attr disabled
     * @attr readonly
     * @attr placeholder
     * @attr inplace
     * @attr instant
     * @attr maxlength
     * @attr cols
     * @attr tabindex
     * @attr onChange
     * @attr onChanging
     * @attr onFocus
     * @attr onBlur
     * @attr onOK
     * @attr onCancel
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def timebox = { attrs, body ->
        doTag(attrs, body, "timebox")
    }

    /**
     *
     * @attr orient
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def toolbar = { attrs, body ->
        doTag(attrs, body, "toolbar")
    }

    /**
     *
     * @attr orient
     * @attr dir
     * @attr href
     * @attr target
     * @attr tabindex
     * @attr disabled
     * @attr mode
     * @attr checked
     * @attr upload
     * @attr image
     * @attr imageContent
     * @attr hoverImage
     * @attr hoverImageContent
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def toolbarbutton = { attrs, body ->
        doTag(attrs, body, "toolbarbutton")
    }

    /**
     *
     * @attr rows
     * @attr name
     * @attr checkmark
     * @attr pageSize
     * @attr paginal
     * @attr onPaging
     * @attr multiple
     * @attr selectedItem
     * @attr model
     * @attr itemRenderer
     * @attr sizedByContent
     * @attr onSelect
     * @attr pagingPosition
     * @attr innerWidth
     * @attr nonselectableTags
     * @attr autopaging
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def tree = { attrs, body ->
        doTag(attrs, body, "tree")
    }

    /**
     *
     * @attr span
     * @attr image
     * @attr imageContent
     * @attr hoverImage
     * @attr hoverImageContent
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     */
    def treecell = { attrs, body ->
        doTag(attrs, body, "treecell")
    }

    /**
     *
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def treechildren = { attrs, body ->
        doTag(attrs, body, "treechildren")
    }

    /**
     *
     * @attr sort
     * @attr sortDirection
     * @attr sortAscending
     * @attr sortDescending
     * @attr maxlength
     * @attr onSort
     * @attr align
     * @attr valign
     * @attr image
     * @attr imageContent
     * @attr hoverImage
     * @attr hoverImageContent
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     */
    def treecol = { attrs, body ->
        doTag(attrs, body, "treecol")
    }

    /**
     *
     * @attr sizable
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def treecols = { attrs, body ->
        doTag(attrs, body, "treecols")
    }

    /**
     *
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def treefoot = { attrs, body ->
        doTag(attrs, body, "treefoot")
    }

    /**
     *
     * @attr align
     * @attr valign
     * @attr span
     * @attr image
     * @attr imageContent
     * @attr hoverImage
     * @attr hoverImageContent
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     */
    def treefooter = { attrs, body ->
        doTag(attrs, body, "treefooter")
    }

    /**
     *
     * @attr value
     * @attr open
     * @attr selected
     * @attr checkable
     * @attr image
     * @attr disabled
     * @attr onOpen
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     */
    def treeitem = { attrs, body ->
        doTag(attrs, body, "treeitem")
    }

    /**
     *
     * @attr label
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     */
    def treerow = { attrs, body ->
        doTag(attrs, body, "treerow")
    }

    /**
     *
     * @attr spacing
     * @attr heights
     * @attr align
     * @attr pack
     * @attr sizedByContent
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def vbox = { attrs, body ->
        doTag(attrs, body, "vbox")
    }

    /**
     *
     * @attr spacing
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def vlayout = { attrs, body ->
        doTag(attrs, body, "vlayout")
    }

    /**
     *
     * @attr flex
     * @attr size
     * @attr splittable
     * @attr collapsible
     * @attr margins
     * @attr open
     * @attr autoscroll
     * @attr border
     * @attr maxsize
     * @attr minsize
     * @attr onOpen
     * @attr title
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def west = { attrs, body ->
        doTag(attrs, body, "west")
    }

    /**
     *
     * @attr border
     * @attr title
     * @attr mode
     * @attr closable
     * @attr sizable
     * @attr position
     * @attr contentStyle
     * @attr minheight
     * @attr minwidth
     * @attr defaultActionOnShow
     * @attr maximizable
     * @attr maximized
     * @attr minimized
     * @attr minimizable
     * @attr contentSclass
     * @attr onOK
     * @attr onCancel
     * @attr onMove
     * @attr onOpen
     * @attr onClose
     * @attr onZIndex
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     * @attr onDoubleClick
     * @attr onClick
     * @attr onRightClick
     * @attr onBookmarkChange
     * @attr onClientInfo
     */
    def window = { attrs, body ->
        doTag(attrs, body, "window")
    }

    /**
     *
     * @attr width
     * @attr height
     * @attr value
     * @attr toolbar
     * @attr onSave
     * @attr hflex
     * @attr vflex
     * @attr customConfigurationsPath
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def ckeditor = { attrs, body ->
        doTag(attrs, body, "ckeditor")
    }

    /**
     *
     * @attr width
     * @attr height
     * @attr value
     * @attr toolbarSet
     * @attr onSave
     * @attr customConfigurationsPath
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def fckeditor = { attrs, body ->
        doTag(attrs, body, "fckeditor")
    }

    /**
     *
     * @attr open
     * @attr lng
     * @attr lat
     * @attr content
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def ginfo = { attrs, body ->
        doTag(attrs, body, "ginfo")
    }

    /**
     *
     * @attr swlng
     * @attr swlat
     * @attr nelng
     * @attr nelat
     * @attr content
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def gimage = { attrs, body ->
        doTag(attrs, body, "gimage")
    }

    /**
     *
     * @attr open
     * @attr lng
     * @attr lat
     * @attr content
     * @attr iconAnchorX
     * @attr iconAnchorY
     * @attr iconDragCrossAnchorX
     * @attr iconDragCrossAnchorY
     * @attr iconDragCrossHeight
     * @attr iconDragCrossImage
     * @attr iconDragCrossWidth
     * @attr iconImage
     * @attr iconImageMap
     * @attr iconInfoAnchorX
     * @attr iconInfoAnchorY
     * @attr iconMaxHeight
     * @attr iconMozPrintImage
     * @attr iconPrintImage
     * @attr iconPrintShadow
     * @attr iconShadow
     * @attr iconShadowHeight
     * @attr iconShadowWidth
     * @attr iconHeight
     * @attr iconWidth
     * @attr iconTransparent
     * @attr onMapDrop
     * @attr onMarkerDrop
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def gmarker = { attrs, body ->
        doTag(attrs, body, "gmarker")
    }

    /**
     *
     * @attr continuousZoom
     * @attr doubleClickZoom
     * @attr enableDragging
     * @attr enableGoogleBar
     * @attr hybrid
     * @attr itemRenderer
     * @attr lat
     * @attr lng
     * @attr mapType
     * @attr model
     * @attr normal
     * @attr physical
     * @attr satellite
     * @attr scrollWheelZoom
     * @attr selectedItem
     * @attr showLargeCtrl
     * @attr showOverviewCtrl
     * @attr showScaleCtrl
     * @attr showSmallCtrl
     * @attr showTypeCtrl
     * @attr showZoomCtrl
     * @attr zoom
     * @attr onMapMove
     * @attr onMapZoom
     * @attr onInfoChange
     * @attr onMapClick
     * @attr onMapDoubleClick
     * @attr onMapDrop
     * @attr onMapRightClick
     * @attr onMarkerDrop
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def gmaps = { attrs, body ->
        doTag(attrs, body, "gmaps")
    }

    /**
     *
     * @attr points
     * @attr color
     * @attr weight
     * @attr opacity
     * @attr numLevels
     * @attr outline
     * @attr fill
     * @attr fillColor
     * @attr fillOpacity
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def gpolygon = { attrs, body ->
        doTag(attrs, body, "gpolygon")
    }

    /**
     *
     * @attr points
     * @attr color
     * @attr weight
     * @attr opacity
     * @attr numLevels
     * @attr context
     * @attr popup
     * @attr tooltip
     * @attr onCtrlKey
     * @attr ctrlKeys
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def gpolyline = { attrs, body ->
        doTag(attrs, body, "gpolyline")
    }

    /**
     *
     * @attr content
     * @attr offsetX
     * @attr offsetY
     * @attr screenX
     * @attr screenY
     * @attr src
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def gscreen = { attrs, body ->
        doTag(attrs, body, "gscreen")
    }

    /**
     *
     * @attr source
     * @attr parameters
     * @attr datasource
     * @attr type
     * @attr width
     * @attr height
     * @attr sclass
     * @attr zclass
     * @attr style
     * @attr left
     * @attr top
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr tooltiptext
     * @attr zindex
     * @attr renderdefer
     * @attr onCreate
     * @attr onDrop
     * @attr action
     * @attr hflex
     * @attr vflex
     * @attr apply
     * @attr auService
     * @attr autag
     * @attr binder
     * @attr children
     * @attr form
     * @attr forward
     * @attr fulfill
     * @attr id
     * @attr mold
     * @attr onFulfill
     * @attr stubonly
     * @attr use
     * @attr viewModel
     * @attr visible
     */
    def jasperreport = { attrs, body ->
        doTag(attrs, body, "jasperreport")
    }

    /**
     *
     * @attr apply
     * @attr context
     * @attr popup
     * @attr ctrlKeys
     * @attr tooltip
     * @attr class
     * @attr left
     * @attr top
     * @attr zIndex
     * @attr zindex
     * @attr height
     * @attr tooltiptext
     * @attr zclass
     * @attr sclass
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr renderdefer
     * @attr vflex
     * @attr hflex
     * @attr width
     * @attr style
     * @attr action
     * @attr id
     * @attr mold
     * @attr widgetClass
     * @attr stubonly
     * @attr definition
     * @attr visible
     */
    def span = { attrs, body ->
        doTag(attrs, body, "span")
    }

    /**
     *
     * @attr apply
     * @attr orient
     * @attr height
     * @attr width
     * @attr context
     * @attr ctrlKeys
     * @attr popup
     * @attr tooltip
     * @attr class
     * @attr left
     * @attr top
     * @attr zIndex
     * @attr zindex
     * @attr tooltiptext
     * @attr zclass
     * @attr sclass
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr renderdefer
     * @attr vflex
     * @attr hflex
     * @attr style
     * @attr action
     * @attr widgetClass
     * @attr id
     * @attr stubonly
     * @attr mold
     * @attr definition
     * @attr visible
     */
    def timeline = { attrs, body ->
        doTag(attrs, body, "timeline")
    }

    /**
     *
     * @attr apply
     * @attr intervalUnit
     * @attr intervalPixels
     * @attr syncWith
     * @attr eventSourceUrl
     * @attr overview
     * @attr bubbleVisible
     */
    def bandinfo = { attrs, body ->
        doTag(attrs, body, "bandinfo")
    }

    /**
     *
     * @attr apply
     * @attr unit
     * @attr multiple
     * @attr magnify
     */
    def hotzone = { attrs, body ->
        doTag(attrs, body, "hotzone")
    }

    /**
     *
     * @attr apply
     * @attr height
     * @attr hideTimeFlag
     * @attr timeFlagFormat
     * @attr width
     * @attr class
     * @attr left
     * @attr top
     * @attr zIndex
     * @attr zindex
     * @attr tooltiptext
     * @attr zclass
     * @attr sclass
     * @attr draggable
     * @attr droppable
     * @attr focus
     * @attr renderdefer
     * @attr vflex
     * @attr hflex
     * @attr style
     * @attr action
     * @attr widgetClass
     * @attr id
     * @attr stubonly
     * @attr mold
     * @attr definition
     * @attr visible
     */
    def timeplot = { attrs, body ->
        doTag(attrs, body, "timeplot")
    }

    /**
     *
     * @attr apply
     * @attr fillColor
     * @attr bubbleHeight
     * @attr bubbleWidth
     * @attr dotColor
     * @attr dotRadius
     * @attr eventLineWidth
     * @attr eventSourceUri
     * @attr lineColor
     * @attr lineWidth
     * @attr roundValues
     * @attr showValues
     * @attr hideValueFlag
     * @attr valuesOpacity
     */
    def plotinfo = { attrs, body ->
        doTag(attrs, body, "plotinfo")
    }

}
